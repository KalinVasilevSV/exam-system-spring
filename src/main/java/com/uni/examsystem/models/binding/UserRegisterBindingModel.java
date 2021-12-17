package com.uni.examsystem.models.binding;

import com.uni.examsystem.models.validator.UniqueFacNumber;
import com.uni.examsystem.models.validator.UniqueUserName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotBlank
    @Size(min = 4)
    @UniqueUserName
    private String username;
    @Size(min = 4)
    @NotNull
    @NotBlank
    private String password;
    @Size(min = 4)
    @NotNull
    @NotBlank
    private String confirmPassword;
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    @NotNull
    private String lastName;
    @NotNull
    @Size(min = 10, max = 10)
    @UniqueFacNumber
    private String facultyNum;


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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public String getFacultyNum() {
        return facultyNum;
    }

    public void setFacultyNum(String facultyNum) {
        this.facultyNum = facultyNum;
    }
}
