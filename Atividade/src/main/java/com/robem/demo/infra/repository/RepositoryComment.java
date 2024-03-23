package com.robem.demo.infra.repository;

import com.robem.demo.infra.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryComment extends JpaRepository<CommentEntity, Long> {
}
