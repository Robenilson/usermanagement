package com.robem.demo.infra.repository;

import com.robem.demo.infra.Bd.PublicationBD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPublicationBD extends JpaRepository<PublicationBD, Long> {
}
