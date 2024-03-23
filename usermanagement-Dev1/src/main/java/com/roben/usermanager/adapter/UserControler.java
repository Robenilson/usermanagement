package com.roben.usermanager.adapter;


import com.roben.usermanager.adapter.DTO.*;
import com.roben.usermanager.core.interfaces.ports.IUserServicer;
import com.roben.usermanager.core.security.domain.RefreshToken;
import com.roben.usermanager.core.services.JwtService;
import com.roben.usermanager.core.services.RefreshTokenService;
import com.roben.usermanager.core.security.domain.Users;
import com.roben.usermanager.core.security.domain.JwtResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    final BCryptPasswordEncoder criptografar;
    final RefreshTokenService  refreshTokenService;
    final JwtService jwtService;


    public UserControler(IUserServicer iUserServicer, AuthenticationManager authenticationManager, BCryptPasswordEncoder criptografar, RefreshTokenService refreshTokenService, JwtService jwtService) {
        this.iUserServicer = iUserServicer;
        this.authenticationManager = authenticationManager;
        this.criptografar = criptografar;
        this.refreshTokenService = refreshTokenService;
        this.jwtService = jwtService;
    }

    @GetMapping("/get")
    public  ResponseEntity<List<GetUserDTO>>  getUserDTOALL(){
        List< GetUserDTO>  getUserDTOS =  new ArrayList<>();
        for (  var users  : this.iUserServicer.getAll()){
            getUserDTOS.add(new GetUserDTO(users.getNome(), users.getDataNacsimento(), users.getEmail(),users.getUserRole().getRole()));
        }
         return  ResponseEntity.ok().body(getUserDTOS);
    }


    @GetMapping("/buscar/{email}")
    public ResponseEntity findByid(@PathVariable String email){
        Users users= this.iUserServicer.findByLogin(email);
        return ResponseEntity.ok().body(new GetUserDTO(users.getNome(), users.getDataNacsimento(),  users.getEmail()  ,users.getUserRole().getRole()));
    }


    @GetMapping("/valid/{token}")
    public ResponseEntity validateToken(@PathVariable String token){
        var logo = this.jwtService.extractUsername(token);
        Users users= this.iUserServicer.findByLogin(logo);
        return ResponseEntity.ok().body(logo);

    }



    @PostMapping("/login")
    public JwtResponse authenticateAndGetToken(@RequestBody AuthenticationDTO obj) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(obj.email(), obj.password()));
        if (authentication.isAuthenticated()) {
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(obj.email());
            return JwtResponse.builder()
                    .accessToken(jwtService.generateToken(obj.email()))
                    .token(refreshToken.getToken()).build();
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

    @PostMapping("/refreshToken")
    public JwtResponse refreshToken(@RequestBody RefreshTokenDTO refreshTokenRequest) {
        return refreshTokenService.findByToken(refreshTokenRequest.token())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUsers)
                .map(getUsers -> {
                    String accessToken = jwtService.generateToken(getUsers.getEmail());
                    return JwtResponse.builder()
                            .accessToken(accessToken)
                            .token(refreshTokenRequest.token())
                            .build();
                }).orElseThrow(() -> new RuntimeException(
                        "Refresh token is not in database!"));
    }







    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity  register(@RequestBody NewUserDTO obj){
        this.iUserServicer.salvar(new Users(obj.nome(),obj.dataNacsimento(),this.criptografar.encode(obj.senha()),obj.email(),obj.role()));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}").buildAndExpand(obj.email()).toUri();
        return  ResponseEntity.created(uri).build();
    }




}
