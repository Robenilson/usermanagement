package com.roben.usermanager.adapter.DTO;

import com.roben.usermanager.core.security.domain.UserRole;

public record NewUserDTO(String nome, String dataNacsimento , String senha, String email, UserRole role) {


}
