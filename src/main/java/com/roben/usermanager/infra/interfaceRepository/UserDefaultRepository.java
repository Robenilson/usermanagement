package com.roben.usermanager.infra.interfaceRepository;

import com.roben.usermanager.infra.entity.DefaultUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDefaultRepository extends JpaRepository<DefaultUser, Long> {
}
