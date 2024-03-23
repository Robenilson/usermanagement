package com.roben.usermanager.core.configuration;
;
import com.roben.usermanager.core.interfaces.ports.IRefreshTokenRepository;
import com.roben.usermanager.core.interfaces.ports.IUserServicer;

import com.roben.usermanager.core.interfaces.ports.IRepositoryUser;
import com.roben.usermanager.core.services.RefreshTokenService;
import com.roben.usermanager.core.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {

    @Bean
    IUserServicer userDefaulService(IRepositoryUser userRepository) {
        return new UserService(userRepository);
    }


    @Bean
    RefreshTokenService RefreshDefaulService(IRefreshTokenRepository refreshTokenRepository) {
        return new RefreshTokenService(refreshTokenRepository);
    }
}
