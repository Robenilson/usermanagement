package com.robem.demo.core.ports;

import com.robem.demo.infra.Bd.PublicationBD;

import java.util.List;

public interface IReposotryPublication {
    public  void save(PublicationBD obj);

    public List<PublicationBD> listPublication(PublicationBD obj);
}
