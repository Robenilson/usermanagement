package com.robem.demo.core.ports;

import com.robem.demo.infra.Entity.PublicationEntity;

import java.util.List;
import java.util.Optional;

public interface IReposotryPublication {
    public  void save(PublicationEntity obj);

    public List<PublicationEntity> listPublication(String email);
}
