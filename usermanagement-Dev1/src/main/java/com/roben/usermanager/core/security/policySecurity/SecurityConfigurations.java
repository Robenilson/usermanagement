package com.roben.usermanager.core.security.policySecurity;

import com.roben.usermanager.core.configuration.BeanConfiguracao;
import com.roben.usermanager.core.interfaces.ports.IRepositoryUser;
import com.roben.usermanager.core.interfaces.ports.IUserServicer;
import com.roben.usermanager.core.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations  {

    final SecurityFillter securityFillter;


    public SecurityConfigurations(SecurityFillter securityFillter) {
        this.securityFillter = securityFillter;
    }

    @Bean
    public SecurityFilterChain securityConfiguration(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf( csrf ->csrf.disable())
                .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/user/login/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/user/email/").permitAll()
                        .requestMatchers(HttpMethod.POST, "/user/register/").permitAll()
                        .requestMatchers(HttpMethod.GET,"/user/get/").hasRole("ADMIN")
                        .anyRequest().authenticated()

                )
                .addFilterBefore(securityFillter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }






    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return  authenticationConfiguration.getAuthenticationManager();

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }






}
