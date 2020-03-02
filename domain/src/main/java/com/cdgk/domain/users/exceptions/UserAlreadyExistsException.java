package com.cdgk.domain.users.exceptions;

import com.cdgk.domain.exceptions.DomainException;
import com.cdgk.domain.exceptions.ErrorCode;

import java.util.Map;

public class UserAlreadyExistsException extends DomainException {
    public UserAlreadyExistsException(Map<Integer, String> data) {
        super(data, ErrorCode.ERR_USER_ALREADY_EXISTS);
    }
}
