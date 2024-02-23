package com.roben.usermanager.adapter.convert;

import com.roben.usermanager.core.security.entitys.UserRole;
import com.roben.usermanager.core.security.entitys.Users;
import com.roben.usermanager.infra.entity.UserBD;

import java.util.ArrayList;
import java.util.List;

public class Adapter {


    public static UserBD convertUsers(Users users){
        UserBD user =new UserBD();
        user.setNome(users.getNome());
        user.setEmail( users.getEmail());
        user.setSenha(users.getPassword());
        user.setDataNacsimento(users.getDataNacsimento());
        user.setRole(String.valueOf(users.getUserRole()));
        return  user;
    }

    public static Users convertUser(UserBD user){
        return  new Users( user.getNome(),user.getDataNacsimento(),user.getSenha(),user.getEmail(),UserRole.valueOf(user.getRole()));
    }



    public  static  List<Users> usersgetAll(List<UserBD> userList){
        List<Users> newUsersList = new ArrayList<>();
        for (UserBD user  :userList){
            newUsersList.add(Adapter.convertUser(user));
        }
        return  newUsersList;

    }


}