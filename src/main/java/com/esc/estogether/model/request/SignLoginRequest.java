package com.esc.estogether.model.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SignLoginRequest {

    private String id;
    private String password;
}
