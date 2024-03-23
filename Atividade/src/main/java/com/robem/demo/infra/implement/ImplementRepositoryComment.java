package com.robem.demo.infra.implement;

import com.robem.demo.core.ports.IRepositoryComment;
import com.robem.demo.infra.repository.RepositoryComment;
import org.springframework.stereotype.Component;

@Component
public class ImplementRepositoryComment implements IRepositoryComment {


    private  final RepositoryComment repositoryComment;


    public ImplementRepositoryComment(RepositoryComment repositoryComment) {
        this.repositoryComment = repositoryComment;
    }
}
