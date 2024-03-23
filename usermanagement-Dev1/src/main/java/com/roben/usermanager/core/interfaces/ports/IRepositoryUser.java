package com.roben.usermanager.core.interfaces.ports;

import com.roben.usermanager.core.security.domain.Users;

import java.util.List;

public interface IRepositoryUser {


    public   void   salvar(Users users);

    public List<Users> getAll();


   public Users findByEmail(String email);

}
