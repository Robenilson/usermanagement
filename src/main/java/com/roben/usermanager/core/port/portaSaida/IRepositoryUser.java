package com.roben.usermanager.core.port.portaSaida;

import com.roben.usermanager.infra.entity.SuperBaseEntity.Users;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface IRepositoryUser {


    public   void   salvar(Users users);


    public UserDetails findByNome(String nome);
}
