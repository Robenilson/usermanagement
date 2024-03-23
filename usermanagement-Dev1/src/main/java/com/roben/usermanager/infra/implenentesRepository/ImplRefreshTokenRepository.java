package com.roben.usermanager.infra.implenentesRepository;

import com.roben.usermanager.adapter.convert.AdapterRefreshToken;
import com.roben.usermanager.core.interfaces.ports.IRefreshTokenRepository;
import com.roben.usermanager.core.security.domain.RefreshToken;
import com.roben.usermanager.infra.repository.RefreshTokenRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ImplRefreshTokenRepository implements IRefreshTokenRepository {
    private final RefreshTokenRepository refreshTokenRepository;


    public ImplRefreshTokenRepository(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }


    @Override
    public RefreshToken save(RefreshToken refreshToken) {
        var inset= this.refreshTokenRepository.save(AdapterRefreshToken.adapterRefreshToken(refreshToken));
        return  AdapterRefreshToken.adapterRefreshTokenEntity(inset);
    }

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return Optional.of(AdapterRefreshToken.adapterRefreshTokenEntity(this.refreshTokenRepository.findByToken(token)));

    }

    @Override
    public List<RefreshToken> getAll() {
        return AdapterRefreshToken.usersgetAll(this.refreshTokenRepository.findAll());
    }

    @Override
    public RefreshToken delete(RefreshToken refreshToken) {
        return null;
    }
}
