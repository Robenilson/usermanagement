package com.roben.usermanager.core.interfaces.ports;

import com.roben.usermanager.core.security.domain.RefreshToken;

import java.util.List;
import java.util.Optional;

public interface IRefreshTokenRepository {

    public  RefreshToken save(RefreshToken refreshToken);
    public Optional<RefreshToken> findByToken(String token);

    public List<RefreshToken> getAll();

    public RefreshToken delete(RefreshToken refreshToken);
}
