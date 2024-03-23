package com.roben.usermanager.core.services;

import com.roben.usermanager.adapter.convert.AdapterUser;
import com.roben.usermanager.core.interfaces.ports.IUserServicer;
import com.roben.usermanager.core.interfaces.ports.IRepositoryUser;
import com.roben.usermanager.core.security.domain.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public class UserService  implements IUserServicer, UserDetailsService {





   private  final IRepositoryUser iRepositoryUserDefault;


    public UserService(IRepositoryUser iRepositoryUserDefault) {
        this.iRepositoryUserDefault = iRepositoryUserDefault;
    }

    @Override
    public void salvar(Users obj) {
        this.iRepositoryUserDefault.salvar(obj);
    }

    @Override
    public Users findByLogin(String email) {
        return  this.iRepositoryUserDefault.findByEmail(email) ;
    }


    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.iRepositoryUserDefault.findByEmail(email);
    }


    @Override
    public List<Users> getAll() {
        return   this.iRepositoryUserDefault.getAll();

    }





}
