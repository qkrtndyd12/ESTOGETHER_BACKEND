package com.esc.estogether.service;

import com.esc.estogether.exception.ApiException;
import com.esc.estogether.exception.ExceptionEnum;
import com.esc.estogether.mapper.LoginMapper;
import com.esc.estogether.model.response.SignLoginResponse;
import com.esc.estogether.token.JwtTokenProvider;
import com.esc.estogether.token.TokenInfo;
import com.esc.estogether.token.User;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {
    private final LoginMapper loginMapper;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String registerUser(String id, String password) {
        validateDuplicated(id);
        int res = loginMapper.saveUser(new User(id, passwordEncoder.encode(password)));
        return "";
//        return new MemberRegisterResponseDto(user.getId(), user.getEmail());
    }

    public void validateDuplicated(String id) {
        if (loginMapper.findByUserId(id).isPresent())
            throw new ApiException(ExceptionEnum.BAD_REQUEST);
    }

    @Transactional
    public SignLoginResponse login(String id, String password) {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(id, password);

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
        User user = (User) authentication.getPrincipal();
        User user1 = User.builder()
                .id(user.getId())
                .refreshToken(tokenInfo.getRefreshToken())
                .lastLogin(user.getLastLogin())
                .member(user.getMember())
                .build();
        loginMapper.updateUser(user1);

        return new SignLoginResponse(user1, tokenInfo);
    }

    @Transactional
    public String refreshToken(String refreshToken) {
        if (!jwtTokenProvider.validateToken(refreshToken)) {
            throw new ApiException(ExceptionEnum.REFRESH_TOKEN_EXPIRED);
        }

        Claims claims = jwtTokenProvider.parseClaims(refreshToken);
        Optional<User> user = loginMapper.findByUserId(claims.get("sub").toString());
        if (user.isPresent()) {
            if (user.get().getRefreshToken().equals(refreshToken) && jwtTokenProvider.validateToken(refreshToken)) {
                return jwtTokenProvider.recreationAccessToken(claims.get("sub").toString(), claims.get("auth"));
            }
        }

        throw new ApiException(ExceptionEnum.REFRESH_TOKEN_EXPIRED);
    }

}
