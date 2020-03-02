package com.cdgk.infra.users;

import com.cdgk.domain.users.User;
import com.cdgk.domain.users.UserProvider;
import com.cdgk.infra.config.ServiceProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserProviderImpl implements UserProvider {

    private UserRepository userRepository;

    @Override
    public String getUserNameFromToken(String token) {
        //TODO
        return token;
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findOneByUserName(userName);
    }


}
