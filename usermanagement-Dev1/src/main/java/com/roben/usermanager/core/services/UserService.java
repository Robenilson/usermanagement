package com.roben.usermanager.core.services;

import com.roben.usermanager.adapter.DTO.GetUserDTO;
import com.roben.usermanager.adapter.DTO.NewUserDTO;
import com.roben.usermanager.adapter.convert.Adapter;
import com.roben.usermanager.core.interfaces.ports.IUserServicer;
import com.roben.usermanager.core.interfaces.ports.IRepositoryUser;
import com.roben.usermanager.core.security.entitys.Users;
import com.roben.usermanager.infra.entity.UserBD;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;


public class UserService  implements IUserServicer, UserDetailsService {





   private  final IRepositoryUser iRepositoryUserDefault;


    public UserService(IRepositoryUser iRepositoryUserDefault) {
        this.iRepositoryUserDefault = iRepositoryUserDefault;
    }

    @Override
    public void salvar(Users obj) {
        this.iRepositoryUserDefault.salvar(Adapter.convertUsers(obj));
    }

    @Override
    public Users findByLogin(String email) {
        return  Adapter.convertUser(this.iRepositoryUserDefault.findByEmail(email)) ;
    }


    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return Adapter.convertUser(this.iRepositoryUserDefault.findByEmail(email) );
    }


    @Override
    public List<Users> getAll() {
        return   Adapter.usersgetAll(this.iRepositoryUserDefault.getAll());

    }





}
