package com.cdgk.domain.users;

public interface UserProvider {

    String getUserNameFromToken(String token);

    User getUserByUserName(String userName);
}
