package com.roben.usermanager.infra.repository;

import com.roben.usermanager.infra.entity.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, Long> {
  RefreshTokenEntity findByToken(String token);

}
