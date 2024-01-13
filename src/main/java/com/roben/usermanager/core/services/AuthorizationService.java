package com.roben.usermanager.core.services;
import com.roben.usermanager.core.port.portaSaida.IRepositoryUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthorizationService implements  UserDetailsService {


   private IRepositoryUser iRepositoryUserDefault;

    public AuthorizationService(IRepositoryUser iRepositoryUserDefault) {
        this.iRepositoryUserDefault = iRepositoryUserDefault;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.iRepositoryUserDefault.findByNome(username);
    }
}
