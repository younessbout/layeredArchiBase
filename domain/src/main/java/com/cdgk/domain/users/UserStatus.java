package com.cdgk.domain.users;

import lombok.Getter;

@Getter
public enum UserStatus {
    ACTIF("ACTIF"),
    DELETED("DELETED"),
    PENDING_VALIDATION("PENDING_VALIDATION");

    String code;

    UserStatus(String code) {
        this.code = code;
    }
}
