package com.robem.demo.adapter.ports;


import com.robem.demo.infra.Bd.PublicationBD;

import java.util.List;

public interface IPublicationServece {

    public  void save(PublicationBD obj);

    public List<PublicationBD> listPublication(PublicationBD obj);
}
