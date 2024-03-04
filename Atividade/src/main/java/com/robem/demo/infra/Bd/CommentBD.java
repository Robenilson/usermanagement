package com.robem.demo.infra.Bd;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CommentBD {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    private String email;
    private String conteudo;
}
