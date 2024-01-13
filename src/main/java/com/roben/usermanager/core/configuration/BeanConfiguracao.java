package com.roben.usermanager.core.configuration;
;
import com.roben.usermanager.core.port.portaEntrada.IUserServicer;
import com.roben.usermanager.core.port.portaSaida.IRepositoryUser;
import com.roben.usermanager.core.services.AuthorizationService;
import com.roben.usermanager.core.services.ImplementUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {





    @Bean
    IUserServicer userDefaulService(IRepositoryUser defalutUser) {
        return new ImplementUserService(defalutUser);
    }



    @Bean
    AuthorizationService authorizationService (IRepositoryUser defalutUser) {
        return new AuthorizationService(defalutUser);
    }

}
