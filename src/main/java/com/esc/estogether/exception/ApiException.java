package com.esc.estogether.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class ApiException extends RuntimeException {
    private ExceptionEnum error;
    private Object body;

    public ApiException(ExceptionEnum e) {
        super(e.getMsg());
        this.error = e;
    }

    public ApiException(ExceptionEnum e, Object body) {
        super(e.getMsg());
        this.error = e;
        this.body = body;
    }

    public ApiException() {

    }
}
