package com.roben.usermanager.adapter.convert;

import com.roben.usermanager.core.security.domain.UserRole;
import com.roben.usermanager.core.security.domain.Users;
import com.roben.usermanager.infra.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class AdapterUser {


    public static UserEntity convertUsers(Users users){
        UserEntity user =new UserEntity();
        user.setId(users.getId());
        user.setNome(users.getNome());
        user.setEmail( users.getEmail());
        user.setSenha(users.getPassword());
        user.setDataNacsimento(users.getDataNacsimento());
        user.setRole(String.valueOf(users.getUserRole()));
        return  user;
    }

    public static Users convertUser(UserEntity user){
        return  new Users(user.getId(), user.getNome(),user.getDataNacsimento(),user.getSenha(),user.getEmail(),UserRole.valueOf(user.getRole()));
    }



    public  static  List<Users> usersgetAll(List<UserEntity> userList){
        List<Users> newUsersList = new ArrayList<>();
        for (UserEntity user  :userList){
            newUsersList.add(AdapterUser.convertUser(user));
        }
        return  newUsersList;
    }


}