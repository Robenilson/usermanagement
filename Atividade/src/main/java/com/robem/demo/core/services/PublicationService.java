package com.robem.demo.core.services;

import com.robem.demo.adapter.Adapter;
import com.robem.demo.core.domain.Publication;
import com.robem.demo.core.ports.IPublicationServece;
import com.robem.demo.adapter.DTO.RecordPublication;
import com.robem.demo.core.ports.IReposotryPublication;

import java.util.List;


public class PublicationService implements IPublicationServece {

    private  final IReposotryPublication reposotryPublication;


    public PublicationService(IReposotryPublication reposotryPublication) {

        this.reposotryPublication = reposotryPublication;
    }

    public  void save( Publication obj){
        this.reposotryPublication.save(Adapter.adptPublicationEntity(obj));
    }


    public List<RecordPublication> listPublication(RecordEmail obj){

        return  Adapter.adptPublicationEntity( this.reposotryPublication.listPublication(obj.email()) );
    }
}
