package com.cdgk.rest.utils;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private String code;
    private String message;
    private String description;
    private List<Error> attributeErrors = new ArrayList<>();

    public void addFieldError(String fieldName, String message) {
        Error error = new Error(fieldName, message);
        attributeErrors.add(error);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class Error {
        private String field;

        private String message;
    }
}
