package com.roben.usermanager.infra.implenentesRepository;

import com.roben.usermanager.adapter.DTO.Convert;
import com.roben.usermanager.core.port.portaSaida.IRepositoryUser;
import com.roben.usermanager.infra.entity.SuperBaseEntity.Users;
import com.roben.usermanager.infra.interfaceR.UserDefaultRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class ImplRepositoryUserDefault  implements IRepositoryUser {


    private final UserDefaultRepository userDefaultRepository;


    public ImplRepositoryUserDefault(UserDefaultRepository userDefaultRepository) {
        this.userDefaultRepository = userDefaultRepository;
    }


    @Override
    public void salvar(Users users) {
        this.userDefaultRepository.save(users);
   }




    @Override
    public UserDetails findByNome(String nome) {

        return (UserDetails) this.userDefaultRepository.findByNome(nome);
    }



}
