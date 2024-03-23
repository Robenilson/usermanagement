package com.roben.usermanager.core.services;

import com.roben.usermanager.adapter.convert.AdapterRefreshToken;
import com.roben.usermanager.core.interfaces.ports.IRefreshTokenRepository;
import com.roben.usermanager.core.security.domain.RefreshToken;
import com.roben.usermanager.infra.repository.RefreshTokenRepository;
import com.roben.usermanager.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {


   final private IRefreshTokenRepository refreshTokenRepository;
    @Autowired
    private UserService userInfoRepository;



    public RefreshTokenService(IRefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public RefreshToken createRefreshToken(String username) {
        RefreshToken refreshToken = RefreshToken.builder()
                .users(userInfoRepository.findByLogin(username))
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(600000))//10
                .build();



        return this.refreshTokenRepository.save(refreshToken);
    }


    public Optional<RefreshToken> findByToken(String token) {
        return this.refreshTokenRepository.findByToken(token);
    }


    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Refresh token was expired. Please make a new signin request");
        }
        return token;
    }
}
