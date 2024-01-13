package com.roben.usermanager.core.services;

import com.roben.usermanager.adapter.DTO.Convert;
import com.roben.usermanager.core.domein.User;
import com.roben.usermanager.core.port.portaEntrada.IUserServicer;
import com.roben.usermanager.core.port.portaSaida.IRepositoryUser;

public class ImplementUserService implements IUserServicer {


   private IRepositoryUser iRepositoryUser;


    public ImplementUserService(IRepositoryUser iRepositoryUserDefault) {
        this.iRepositoryUser = iRepositoryUserDefault;
    }


    @Override
    public void salvar(User user) {
        Convert convert = new Convert(user.getNome(), user.getDataNacsimento(), user.getSenha(), user.getEmail(), user.getRole());
        this.iRepositoryUser.salvar(convert.ConvertUsers());

    }

}
