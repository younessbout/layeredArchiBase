package com.cdgk.application.exceptions;

import com.cdgk.domain.exceptions.ErrorCode;
import lombok.Getter;

import java.util.Map;

@Getter
public class ApplicationException extends Exception {
    private final String code;
    private final String message;
    private final String description;
    private final int httpCode;
    private final Map<Integer, String> data;

    public ApplicationException() {
        code = null;
        message = null;
        description = null;
        httpCode = 0;
        this.data = null;
    }

    public ApplicationException(ErrorCode errorCode) {
        super(errorCode.getDefaultMessage());
        this.code = errorCode.getCode();
        this.message = errorCode.getDefaultMessage();
        this.description = errorCode.getDefaultDescription();
        this.httpCode = errorCode.getSuggestedHttpCode();
        this.data = null;
    }

    public ApplicationException(ErrorCode errorCode, Map<Integer, String> data) {
        super(errorCode.getDefaultMessage());
        this.code = errorCode.getCode();
        this.message = errorCode.getDefaultMessage();
        this.description = errorCode.getDefaultDescription();
        this.httpCode = errorCode.getSuggestedHttpCode();
        this.data = data;
    }
}
