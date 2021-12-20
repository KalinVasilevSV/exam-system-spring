package com.uni.examsystem.models.view;

import com.uni.examsystem.models.entities.ExamEntity;
import com.uni.examsystem.models.entities.UserRoleEntity;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsView {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String facNo;
    private boolean canEdit;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

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

}
