package com.roben.usermanager.adapter;


import com.roben.usermanager.adapter.DTO.ManagerUserDTO;
import com.roben.usermanager.core.interfaces.portaEntrada.IUserManegerServicer;
import com.roben.usermanager.infra.entity.ManagerUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteControler {


    private IUserManegerServicer iUserManegerServicer;


    public TesteControler(IUserManegerServicer iUserManegerServicer) {
        this.iUserManegerServicer = iUserManegerServicer;
    }



    @GetMapping
    void criarProdutos(@RequestBody ManagerUserDTO managerUserDTO) {
        this.iUserManegerServicer.salvar(managerUserDTO);
    }

}
