package com.roben.usermanager.core.security.domain;

import com.roben.usermanager.infra.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RefreshToken {


    private  Long id;
    private  String token;
    private Instant expiryDate;
    private Users users;
}
