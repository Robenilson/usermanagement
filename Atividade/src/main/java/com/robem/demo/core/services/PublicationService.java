package com.robem.demo.core.services;

import com.robem.demo.adapter.ports.IPublicationServece;
import com.robem.demo.core.ports.IReposotryPublication;
import com.robem.demo.infra.Bd.PublicationBD;

import java.util.List;


public class PublicationService implements IPublicationServece {

    private  final IReposotryPublication reposotryPublication;


    public PublicationService(IReposotryPublication reposotryPublication) {
        this.reposotryPublication = reposotryPublication;
    }

    public  void save(PublicationBD obj){
        this.reposotryPublication.save(obj);
    }


    public List<PublicationBD> listPublication(PublicationBD obj){
        return  this.reposotryPublication.listPublication(obj);
    }
}
