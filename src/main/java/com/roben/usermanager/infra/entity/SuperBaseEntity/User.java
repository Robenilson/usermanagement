package com.roben.usermanager.infra.entity.SuperBaseEntity;

import jakarta.persistence.*;
import lombok.Data;



@Data
@MappedSuperclass
public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataNacsimento;
    private String senha;
    private String email;


}

