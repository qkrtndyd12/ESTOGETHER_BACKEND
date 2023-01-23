package com.esc.estogether.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ExceptionEnum {
    BAD_REQUEST(HttpStatus.BAD_REQUEST, 40000),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, 40100),
    FORBIDDEN(HttpStatus.FORBIDDEN, 40300),
    REFRESH_TOKEN_EXPIRED(HttpStatus.FORBIDDEN, 40301),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 50000),
    NOT_IMPLEMENTED(HttpStatus.NOT_IMPLEMENTED, 50100),
    SERVICE_UNAVAILABLE(HttpStatus.NOT_IMPLEMENTED, 50300),
    ;

    private final HttpStatus status;
    private final int code;
    private String msg;

    ExceptionEnum(HttpStatus status, int code) {
        this.status = status;
        this.code = code;
    }
    ExceptionEnum(HttpStatus status, int code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }
}
