package com.roben.usermanager.adapter;


import com.roben.usermanager.adapter.DTO.*;
import com.roben.usermanager.core.interfaces.ports.IUserServicer;
import com.roben.usermanager.core.services.TokenService;
import com.roben.usermanager.core.security.entitys.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserControler {

   final IUserServicer iUserServicer;
    final AuthenticationManager  authenticationManager;
    final  TokenService tokenService;
    final BCryptPasswordEncoder criptografar;


    public UserControler(IUserServicer iUserServicer, AuthenticationManager authenticationManager, TokenService tokenService, BCryptPasswordEncoder criptografar) {
        this.iUserServicer = iUserServicer;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.criptografar = criptografar;
    }

    @GetMapping("/get/")
    public  ResponseEntity<List<GetUserDTO>>  getUserDTOALL(){
        List< GetUserDTO>  getUserDTOS =  new ArrayList<>();
        for (  var users  : this.iUserServicer.getAll()){
            getUserDTOS.add(new GetUserDTO(users.getNome(), users.getDataNacsimento(), users.getEmail(),users.getUserRole().getRole()));
        }
         return  ResponseEntity.ok().body(getUserDTOS);
    }


    @GetMapping("/email/")
    public ResponseEntity findByid(@RequestBody EmailDTO  obj){
        Users users= this.iUserServicer.findByLogin(obj.email());
        return ResponseEntity.ok().body(new GetUserDTO(users.getNome(), users.getDataNacsimento(),  users.getEmail()  ,users.getUserRole().getRole()));
    }


    @PostMapping
    @RequestMapping("/login/")
    public ResponseEntity  login(@RequestBody AuthenticationDTO obj){
        var  usernamePassword = new UsernamePasswordAuthenticationToken( obj.email(), obj.password());
        var auth= this.authenticationManager.authenticate(usernamePassword);
        var token= tokenService.generateToken((Users) auth.getPrincipal());
        return  ResponseEntity.ok().body(new LoginResponseDTO(token));
    }
    @PostMapping
    @RequestMapping("/register/")
    public ResponseEntity  register(@RequestBody NewUserDTO obj){
        this.iUserServicer.salvar(new Users(obj.nome(),obj.dataNacsimento(),this.criptografar.encode(obj.senha()),obj.email(),obj.role()));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}").buildAndExpand(obj.email()).toUri();
        return  ResponseEntity.created(uri).build();
    }




}
