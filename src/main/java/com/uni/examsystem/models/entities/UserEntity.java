package com.uni.examsystem.models.entities;

import com.uni.examsystem.models.entities.enums.UserRoleEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class UserEntity extends BaseEntity{

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private  String lastName;
    @Column(nullable = false)
    private String facNo;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoleEnum role;
    @ManyToMany
    private Set<ExamEntity> exams;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFacNo() {
        return facNo;
    }

    public void setFacNo(String facNo) {
        this.facNo = facNo;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

}
