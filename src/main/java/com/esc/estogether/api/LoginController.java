package com.esc.estogether.api;


import com.esc.estogether.model.request.SignLoginRequest;
import com.esc.estogether.model.request.SignRefreshRequest;
import com.esc.estogether.model.response.SignLoginResponse;
import com.esc.estogether.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping(value = "/sign")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public SignLoginResponse login(@RequestBody SignLoginRequest signLoginRequest) throws Exception {
        return loginService.login(signLoginRequest.getId(), signLoginRequest.getPassword());
    }

    @PostMapping("/refresh")
    public String refresh(@RequestBody SignRefreshRequest signRefreshRequest) throws Exception {
        return loginService.refreshToken(signRefreshRequest.getRefreshToken());
    }
}
