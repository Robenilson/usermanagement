package com.roben.usermanager.infra.entity;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity( name = "users")
@Table( name = "users" )
public  class UserBD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataNacsimento;
    private String senha;
    @Column(unique = true)
    private String email;
    private  String role;


}

