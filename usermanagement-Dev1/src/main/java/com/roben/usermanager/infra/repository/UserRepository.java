package com.roben.usermanager.infra.repository;

import com.roben.usermanager.infra.entity.UserBD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserBD, Long> {
      UserBD findByEmail(String email);
}
