package com.robem.demo.core.ports;


import com.robem.demo.adapter.DTO.RecordPublication;
import com.robem.demo.core.domain.Publication;

import java.util.List;

public interface IPublicationServece {

    public  void save( Publication obj);

    public  List<RecordPublication>  listPublication(String obj);
}
