package com.roben.usermanager.core.services;

import com.roben.usermanager.adapter.DTO.ManagerUserDTO;
import com.roben.usermanager.adapter.DTO.UserDefalutDTO;
import com.roben.usermanager.core.interfaces.portaEntrada.IUserDefaultServicer;
import com.roben.usermanager.core.interfaces.portaEntrada.IUserManegerServicer;
import com.roben.usermanager.core.interfaces.portaSaida.IRepositoryUserDefault;
import com.roben.usermanager.core.interfaces.portaSaida.IRepositoryUserManeger;

public class UserDefaultService implements IUserDefaultServicer {


   private IRepositoryUserDefault iRepositoryUserDefault;


    public UserDefaultService(IRepositoryUserDefault iRepositoryUserDefault) {
        this.iRepositoryUserDefault = iRepositoryUserDefault;
    }

    @Override
    public void salvar(UserDefalutDTO userDefalutDTO) {
        this.iRepositoryUserDefault.salvar(userDefalutDTO);




    }
}
