package com.uni.examsystem.models.binding;

import com.uni.examsystem.models.entities.ExamEntity;
import com.uni.examsystem.models.entities.UserRoleEntity;
import com.uni.examsystem.models.validator.UniqueFacNumber;
import com.uni.examsystem.models.validator.UniqueUserName;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class UserUpdateBindingModel {

    private Long id;
    @NotBlank
    @Size(min = 4)
    @UniqueUserName
    private String username;
    @Size(min = 4)
    @NotNull
    @NotBlank
    private String password;
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    @NotNull
    private String lastName;
    @NotNull
    @Size(min = 10, max = 10)
    @UniqueFacNumber
    private String facNo;

    public UserUpdateBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
