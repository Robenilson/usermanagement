package com.robem.demo.infra.implement;

import com.robem.demo.core.ports.IReposotryPublication;
import com.robem.demo.infra.Entity.PublicationEntity;
import com.robem.demo.infra.repository.RepositoryPublication;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ImplementReposotryPublication implements IReposotryPublication {


    private RepositoryPublication reposotryPublication;



    public ImplementReposotryPublication(RepositoryPublication reposotryPublication) {
        this.reposotryPublication = reposotryPublication;
    }


    public  void save(PublicationEntity obj){
        this.reposotryPublication.save(obj);
    }

    public List<PublicationEntity> listPublication(String email){
        return this.reposotryPublication.findByEmail(email);
    }

    public  void update(PublicationEntity obj){

    }





}






