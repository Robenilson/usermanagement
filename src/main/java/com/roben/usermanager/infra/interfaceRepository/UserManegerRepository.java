package com.roben.usermanager.infra.interfaceRepository;

import com.roben.usermanager.infra.entity.ManagerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserManegerRepository  extends JpaRepository<ManagerUser, Long> {
}
