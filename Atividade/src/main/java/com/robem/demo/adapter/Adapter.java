package com.robem.demo.adapter;

import com.robem.demo.adapter.DTO.RecordPublication;
import com.robem.demo.core.domain.Publication;
import com.robem.demo.infra.Entity.PublicationEntity;

import java.util.ArrayList;
import java.util.List;

public class Adapter {


    public  static PublicationEntity adptPublicationEntity(Publication obj){
        PublicationEntity publicationBD = new PublicationEntity();
        publicationBD.setContent(obj.getContent());
        publicationBD.setEmail(obj.getEmail());
        publicationBD.setTitlulo(obj.getTitlulo());
        return  publicationBD;
    }



    public  static List<RecordPublication> adptPublicationEntity(List<PublicationEntity> obj){
      List<RecordPublication> recordPublications = new ArrayList<>();
       for (PublicationEntity  publicationBD  : obj)
           recordPublications.add(Adapter.recordPublication(publicationBD));
    return  recordPublications;
    }

    public  static RecordPublication recordPublication(PublicationEntity obj){
        return   new RecordPublication( obj.getEmail(), obj.getTitlulo(),obj.getContent());
    }
}
