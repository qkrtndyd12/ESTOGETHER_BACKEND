package com.esc.estogether.model.response;

import com.esc.estogether.token.TokenInfo;
import com.esc.estogether.token.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SignLoginResponse {
    private User user;
    private TokenInfo tokenInfo;
}
