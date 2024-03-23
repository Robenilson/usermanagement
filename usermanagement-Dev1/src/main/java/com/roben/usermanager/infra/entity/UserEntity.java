package com.roben.usermanager.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity( name = "users")
@Table( name = "users" )
@AllArgsConstructor
@NoArgsConstructor
public  class UserEntity {
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

