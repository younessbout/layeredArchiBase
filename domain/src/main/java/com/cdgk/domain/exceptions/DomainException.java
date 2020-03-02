package com.cdgk.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class DomainException extends Exception {
    protected final Map<Integer, String> data;
    protected final ErrorCode code;
}
