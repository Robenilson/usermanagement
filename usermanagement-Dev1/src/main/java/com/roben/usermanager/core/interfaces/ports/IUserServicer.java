package com.roben.usermanager.core.interfaces.ports;

import com.roben.usermanager.adapter.DTO.GetUserDTO;
import com.roben.usermanager.adapter.DTO.NewUserDTO;
import com.roben.usermanager.core.security.entitys.Users;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IUserServicer {

    public   void   salvar(Users obj);

    public Users findByLogin(String email );

    public UserDetails loadUserByUsername(String email);

    public List<Users> getAll();


}
