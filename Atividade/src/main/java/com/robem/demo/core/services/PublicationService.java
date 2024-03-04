package com.robem.demo.core.services;

import com.robem.demo.adapter.ports.IPublicationServece;
import com.robem.demo.core.ports.IReposotryPublication;


public class PublicationService implements IPublicationServece {

    private  final IReposotryPublication reposotryPublication;


    public PublicationService(IReposotryPublication reposotryPublication) {
        this.reposotryPublication = reposotryPublication;
    }
}
