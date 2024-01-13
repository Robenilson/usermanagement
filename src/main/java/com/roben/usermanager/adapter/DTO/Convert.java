package com.roben.usermanager.adapter.DTO;


import com.roben.usermanager.core.domein.UserRole;
import com.roben.usermanager.infra.entity.SuperBaseEntity.Users;


public class Convert  {

    private String nome;
    private String dataNacsimento;
    private String senha;
    private String email;

    private  UserRole role;

    public Convert(String nome, String dataNacsimento, String senha, String email, UserRole role) {
        this.nome = nome;
        this.dataNacsimento = dataNacsimento;
        this.senha = senha;
        this.email = email;
        this.role = role;
    }


    public Users ConvertUsers(){
        Users users= new  Users();
        users.setEmail(this.email);
        users.setNome(this.nome);
        users.setRole(this.role.getRole());
        users.setDataNacsimento(this.dataNacsimento);
        users.setSenha(this.senha);
        return  users;
    }


}
