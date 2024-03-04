package com.robem.demo.infra.implement;

import com.robem.demo.core.ports.IRepositoryComment;
import com.robem.demo.infra.repository.RepositoryCommentBD;
import org.springframework.stereotype.Component;

@Component
public class ImplementRepositoryComment implements IRepositoryComment {


    private  final RepositoryCommentBD repositoryComment;



    public ImplementRepositoryComment(RepositoryCommentBD repositoryComment) {
        this.repositoryComment = repositoryComment;
    }
}
