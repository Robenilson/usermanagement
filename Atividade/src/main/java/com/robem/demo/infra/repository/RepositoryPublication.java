package com.robem.demo.infra.repository;

import com.robem.demo.infra.Entity.PublicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPublication extends JpaRepository<PublicationEntity, Long> {
 List<PublicationEntity> findByEmail(String email);
}
