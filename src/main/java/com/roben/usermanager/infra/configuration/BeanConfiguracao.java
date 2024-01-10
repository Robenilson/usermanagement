package com.roben.usermanager.infra.configuration;
;
import com.roben.usermanager.core.interfaces.portaEntrada.IUserDefaultServicer;
import com.roben.usermanager.core.interfaces.portaEntrada.IUserManegerServicer;
import com.roben.usermanager.core.interfaces.portaSaida.IRepositoryUserDefault;
import com.roben.usermanager.core.interfaces.portaSaida.IRepositoryUserManeger;
import com.roben.usermanager.core.services.UserDefaultService;
import com.roben.usermanager.core.services.UserManegerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {
    @Bean
    IUserManegerServicer userManegeService(IRepositoryUserManeger defalutUser) {
        return new UserManegerService(defalutUser);
    }




    @Bean
    IUserDefaultServicer userDefaulService(IRepositoryUserDefault defalutUser) {
        return new UserDefaultService(defalutUser);
    }


}
