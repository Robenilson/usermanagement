package com.roben.usermanager.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
@Entity( name = "refresh_token")
@Table( name = "refresh_token" )
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String token;
    private Instant expiryDate;

    @OneToOne
    @JoinColumn( name = "use_id", referencedColumnName = "id")
    private UserEntity users;
}
