package com.robem.demo.adapter.controller;


import com.robem.demo.adapter.ports.ICommetServece;
import com.robem.demo.adapter.ports.IPublicationServece;
import com.robem.demo.adapter.record.RecordPublication;
import com.robem.demo.infra.Bd.PublicationBD;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerPubication {

    private final ICommetServece  iCommetServece;
    private final IPublicationServece iPublicationServece;



    public ControllerPubication(ICommetServece iCommetServece, IPublicationServece iPublicationServece) {
        this.iCommetServece = iCommetServece;
        this.iPublicationServece = iPublicationServece;
    }



    @PostMapping
    public  void save( @RequestBody RecordPublication obj){
        PublicationBD publicationBD = new PublicationBD();
        publicationBD.setContent(obj.content());
        publicationBD.setEmail(obj.email());
        publicationBD.setTitlulo(obj.titlulo());
        this.iPublicationServece.save(publicationBD);
    }

    @GetMapping
    public List<PublicationBD> listPublication(PublicationBD obj){
        return  this.iPublicationServece.listPublication(obj);
    }
}
