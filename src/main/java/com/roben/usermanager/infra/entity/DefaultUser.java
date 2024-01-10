package com.roben.usermanager.infra.entity;

import com.roben.usermanager.infra.entity.SuperBaseEntity.User;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class DefaultUser  extends User {

    private  String notification;
}
