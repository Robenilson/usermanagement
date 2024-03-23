package com.roben.usermanager.infra.implenentesRepository;

import com.roben.usermanager.adapter.convert.AdapterUser;
import com.roben.usermanager.core.interfaces.ports.IRepositoryUser;
import com.roben.usermanager.core.security.domain.Users;
import com.roben.usermanager.infra.entity.UserEntity;
import com.roben.usermanager.infra.repository.UserRepository;
import org.apache.coyote.Adapter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImplRepository implements IRepositoryUser {

    private final UserRepository userRepository;

    public ImplRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void salvar( Users users) {
        this.userRepository.save(AdapterUser.convertUsers(users));
    }


    @Override
    public List<Users> getAll() {
     return  AdapterUser.usersgetAll( this.userRepository.findAll()) ;
    }

    @Override
    public Users findByEmail(String email) {
        return  AdapterUser.convertUser(this.userRepository.findByEmail(email));

    }


}
