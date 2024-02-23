package com.roben.usermanager.infra.implenentesRepository;

import com.roben.usermanager.adapter.convert.Adapter;
import com.roben.usermanager.core.interfaces.ports.IRepositoryUser;
import com.roben.usermanager.core.security.entitys.Users;
import com.roben.usermanager.infra.entity.UserBD;
import com.roben.usermanager.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImplRepository implements IRepositoryUser {

    private final UserRepository userRepository;

    public ImplRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void salvar(UserBD users) {
        this.userRepository.save(users);
    }


    @Override
    public List<UserBD> getAll() {
     return   this.userRepository.findAll();
    }

    @Override
    public UserBD findByEmail(String email) {
        return this.userRepository.findByEmail(email);

    }


}
