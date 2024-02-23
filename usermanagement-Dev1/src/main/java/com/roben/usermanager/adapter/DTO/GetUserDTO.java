package com.roben.usermanager.adapter.DTO;

import com.roben.usermanager.core.security.entitys.UserRole;

public record GetUserDTO(String nome, String dataNacsimento , String email, String role) {

}
