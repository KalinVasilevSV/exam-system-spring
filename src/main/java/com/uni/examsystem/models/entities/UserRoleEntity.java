package com.uni.examsystem.models.entities;

import com.uni.examsystem.models.entities.enums.UserRoleEnum;

import javax.persistence.*;

@Table(name = "ROLES")
@Entity
public class UserRoleEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }
}
