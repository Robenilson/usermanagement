package com.roben.usermanager.infra.interfaceR;

import com.roben.usermanager.core.domein.User;
import com.roben.usermanager.infra.entity.SuperBaseEntity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDefaultRepository extends JpaRepository<Users, Long> {


    public Object findByNome(String nome);
}
