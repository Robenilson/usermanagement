package com.robem.demo.core.services;

import com.robem.demo.adapter.ports.ICommetServece;
import com.robem.demo.core.ports.IRepositoryComment;


public class CommentService  implements ICommetServece {



    private  final IRepositoryComment repositoryComment;


    public CommentService(IRepositoryComment repositoryComment) {
        this.repositoryComment = repositoryComment;
    }
}
