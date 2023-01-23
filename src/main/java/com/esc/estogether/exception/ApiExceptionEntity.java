package com.esc.estogether.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class ApiExceptionEntity {
    private int code;
    private String msg;
    private final int v = 1;

    @Builder
    public ApiExceptionEntity(HttpStatus status, int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
