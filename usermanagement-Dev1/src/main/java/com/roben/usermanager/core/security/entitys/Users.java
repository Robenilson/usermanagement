package com.roben.usermanager.core.security.entitys;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;




@ToString
public class Users implements UserDetails {



    @Getter  @Setter private Long id;
    @Getter @Setter     private String nome;
    @Getter  @Setter    private String dataNacsimento;
    @Getter @Setter private String senha;
    @Getter  @Setter private String email;
    @Getter@Setter private UserRole userRole;

    public Users( String nome, String dataNacsimento, String senha, String email, UserRole userRole) {
        this.setNome(nome);
        this.setDataNacsimento(dataNacsimento);
        this.setEmail(email);
        this.setUserRole(userRole);
        this.setSenha( senha);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
                if (this.getUserRole() == UserRole.ADMIN ) return List.of( new SimpleGrantedAuthority( "ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
                else  return  List.of( new SimpleGrantedAuthority("ROLE_USER"));


    }

    @Override
    public String getPassword() {
        return this.senha;
    }


    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
