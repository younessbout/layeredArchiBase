package com.cdgk.application.exceptions;

import com.cdgk.domain.exceptions.DomainException;

public class DomainExceptionTranslator {

    private DomainExceptionTranslator() {
    }

    public static ApplicationException fromDomainException(DomainException exception) {
        return new ApplicationException(exception.getCode(), exception.getData());
    }
}
