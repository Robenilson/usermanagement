package com.robem.demo.adapter.controller;


import com.robem.demo.adapter.ports.ICommetServece;
import com.robem.demo.adapter.ports.IPublicationServece;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPubication {

    private final ICommetServece  iCommetServece;
    private final IPublicationServece iPublicationServece;



    public ControllerPubication(ICommetServece iCommetServece, IPublicationServece iPublicationServece) {
        this.iCommetServece = iCommetServece;
        this.iPublicationServece = iPublicationServece;
    }
}
