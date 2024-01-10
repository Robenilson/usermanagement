package com.roben.usermanager.infra.implenentesRepository;

import com.roben.usermanager.adapter.DTO.ManagerUserDTO;
import com.roben.usermanager.adapter.DTO.UserDefalutDTO;
import com.roben.usermanager.core.interfaces.portaSaida.IRepositoryUserDefault;
import com.roben.usermanager.core.interfaces.portaSaida.IRepositoryUserManeger;
import com.roben.usermanager.infra.entity.DefaultUser;
import com.roben.usermanager.infra.entity.ManagerUser;
import com.roben.usermanager.infra.interfaceRepository.UserDefaultRepository;
import org.springframework.stereotype.Component;

@Component
public class ImplRepositoryUserDefault  implements IRepositoryUserDefault {


    private final UserDefaultRepository userDefaultRepository;


    public ImplRepositoryUserDefault(UserDefaultRepository userDefaultRepository) {
        this.userDefaultRepository = userDefaultRepository;
    }


    @Override
    public void salvar(UserDefalutDTO userDefalutDTO) {
        this.userDefaultRepository.save(this.managerUserConvert(userDefalutDTO));
    }




    private DefaultUser managerUserConvert(UserDefalutDTO userDefalutDTO) {
        DefaultUser defaultUser = new DefaultUser();
        defaultUser.setNome(userDefalutDTO.getNome());
        defaultUser.setEmail(userDefalutDTO.getEmail());
        defaultUser.setSenha(userDefalutDTO.getSenha());
        defaultUser.setDataNacsimento(userDefalutDTO.getDataNacsimento());
        defaultUser.setNotification(userDefalutDTO.getNotification());
        return defaultUser;

    }
}
