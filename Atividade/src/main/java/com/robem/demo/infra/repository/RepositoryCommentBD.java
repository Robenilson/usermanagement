package com.robem.demo.infra.repository;

import com.robem.demo.infra.Bd.CommentBD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCommentBD extends JpaRepository<CommentBD, Long> {
}
