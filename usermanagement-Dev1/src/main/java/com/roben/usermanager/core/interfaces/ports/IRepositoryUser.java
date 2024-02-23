package com.roben.usermanager.core.interfaces.ports;

import com.roben.usermanager.core.security.entitys.Users;

import com.roben.usermanager.infra.entity.UserBD;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IRepositoryUser {


    public   void   salvar(UserBD users);

    public List<UserBD> getAll();


   public UserBD findByEmail(String email);

}
