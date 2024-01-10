package com.roben.usermanager.core.services;

import com.roben.usermanager.adapter.DTO.ManagerUserDTO;
import com.roben.usermanager.core.interfaces.portaEntrada.IUserManegerServicer;
import com.roben.usermanager.core.interfaces.portaSaida.IRepositoryUserManeger;

public class UserManegerService implements IUserManegerServicer {


   private IRepositoryUserManeger iRepositoryUserManeger;


    public UserManegerService(IRepositoryUserManeger iRepositoryUserManeger) {
        this.iRepositoryUserManeger = iRepositoryUserManeger;
    }

    @Override
    public void salvar(ManagerUserDTO managerUser) {
        this.iRepositoryUserManeger.salvar(managerUser);




    }
}
