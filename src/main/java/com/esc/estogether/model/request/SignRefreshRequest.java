package com.esc.estogether.model.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SignRefreshRequest {

    private String id;
    private String refreshToken;
}
