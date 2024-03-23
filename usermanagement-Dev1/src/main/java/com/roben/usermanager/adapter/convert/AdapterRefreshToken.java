package com.roben.usermanager.adapter.convert;

import com.roben.usermanager.core.security.domain.RefreshToken;
import com.roben.usermanager.core.security.domain.Users;
import com.roben.usermanager.infra.entity.RefreshTokenEntity;
import com.roben.usermanager.infra.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class AdapterRefreshToken {

    public  static RefreshToken adapterRefreshTokenEntity(RefreshTokenEntity refreshTokenEntity){
        var  refreshToken= new RefreshToken();
        refreshToken.setId(refreshTokenEntity.getId());
        refreshToken.setExpiryDate(refreshTokenEntity.getExpiryDate());
        refreshToken.setToken(refreshTokenEntity.getToken());
        refreshToken.setUsers(AdapterUser.convertUser(refreshTokenEntity.getUsers()));
        return refreshToken;

    }


    public  static RefreshTokenEntity adapterRefreshToken(RefreshToken refreshToken){
        var  refreshTokenEntity= new RefreshTokenEntity();
        refreshTokenEntity.setId(refreshToken.getId());
        refreshTokenEntity.setExpiryDate(refreshToken.getExpiryDate());
        refreshTokenEntity.setToken(refreshToken.getToken());
        var log=AdapterUser.convertUsers(refreshToken.getUsers());
        refreshTokenEntity.setUsers(log);
        return refreshTokenEntity;

    }

    public  static List<RefreshToken> usersgetAll(List<RefreshTokenEntity> refreshTokenEntities){
        List<RefreshToken> refreshTokens = new ArrayList<>();
        for (RefreshTokenEntity refreshTokenEntity :refreshTokenEntities){
            refreshTokens.add(AdapterRefreshToken.adapterRefreshTokenEntity((RefreshTokenEntity) refreshTokenEntities));
        }
        return  refreshTokens;
    }

}
