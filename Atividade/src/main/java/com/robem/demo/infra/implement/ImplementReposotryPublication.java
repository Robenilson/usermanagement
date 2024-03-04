package com.robem.demo.infra.implement;

import com.robem.demo.core.ports.IReposotryPublication;
import com.robem.demo.infra.repository.RepositoryPublicationBD;
import org.springframework.stereotype.Component;


@Component
public class ImplementReposotryPublication implements IReposotryPublication {


    private RepositoryPublicationBD reposotryPublication;



    public ImplementReposotryPublication(RepositoryPublicationBD reposotryPublication) {
        this.reposotryPublication = reposotryPublication;
    }
}
