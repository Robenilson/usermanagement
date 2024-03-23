package com.robem.demo.adapter.controller;


import com.robem.demo.core.domain.Publication;
import com.robem.demo.core.ports.ICommetServece;
import com.robem.demo.core.ports.IPublicationServece;
import com.robem.demo.adapter.DTO.RecordPublication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
        RestTemplate restTemplate = new RestTemplate();
        String user = restTemplate.getForEntity("http://localhost:8081/user/valid/"+ obj.token()+" ", String.class).getBody();
        Publication publication= new Publication();
        publication.setContent(obj.content());
        publication.setTitlulo(obj.titlulo());
        publication.setEmail(user);
        this.iPublicationServece.save(publication);
    }

    @GetMapping
    public List<RecordPublication> listPublication(@RequestBody String obj){
       return  this.iPublicationServece.listPublication(obj);

    }


}
