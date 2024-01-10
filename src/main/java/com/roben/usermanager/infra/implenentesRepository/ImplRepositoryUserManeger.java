package com.roben.usermanager.infra.implenentesRepository;

import com.roben.usermanager.adapter.DTO.ManagerUserDTO;
import com.roben.usermanager.core.interfaces.portaSaida.IRepositoryUserManeger;
import com.roben.usermanager.infra.entity.ManagerUser;
import com.roben.usermanager.infra.interfaceRepository.UserManegerRepository;
import org.springframework.stereotype.Component;


@Component
public  class ImplRepositoryUserManeger implements IRepositoryUserManeger {


    private final UserManegerRepository userManegerRepository;


    public ImplRepositoryUserManeger(UserManegerRepository userManegerRepository) {
        this.userManegerRepository = userManegerRepository;
    }

    @Override
    public void salvar(ManagerUserDTO managerUserDTO) {
        this.userManegerRepository.save(this.managerUserConvert(managerUserDTO));

    }



    private  ManagerUser managerUserConvert(ManagerUserDTO ManagerUserDTO) {
        ManagerUser managerUser = new ManagerUser();
        managerUser.setNome(ManagerUserDTO.getNome());
        managerUser.setEmail(ManagerUserDTO.getEmail());
        managerUser.setSenha(ManagerUserDTO.getSenha());
        managerUser.setDataNacsimento(ManagerUserDTO.getDataNacsimento());
        return managerUser;

    }
}
