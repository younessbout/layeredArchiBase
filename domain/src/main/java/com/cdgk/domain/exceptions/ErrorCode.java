package com.cdgk.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class ErrorCode implements Serializable {

    public static final ErrorCode ERR_USER_ALREADY_EXISTS = new ErrorCode("err.users.userAlreadyExists", "User Already Exists", "User Already Exists", 403);;

    private String code;
    private String defaultMessage;
    private String defaultDescription;
    private int suggestedHttpCode;

}
