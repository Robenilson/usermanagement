package com.robem.demo.infra.implement;

import com.robem.demo.core.ports.IReposotryPublication;
import com.robem.demo.infra.Bd.PublicationBD;
import com.robem.demo.infra.repository.RepositoryPublicationBD;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ImplementReposotryPublication implements IReposotryPublication {


    private RepositoryPublicationBD reposotryPublication;



    public ImplementReposotryPublication(RepositoryPublicationBD reposotryPublication) {
        this.reposotryPublication = reposotryPublication;
    }


    public  void save(PublicationBD obj){

        this.reposotryPublication.save(obj);

    }

    public List<PublicationBD> listPublication(PublicationBD obj){
        return  this.reposotryPublication.findAll();
    }






}






