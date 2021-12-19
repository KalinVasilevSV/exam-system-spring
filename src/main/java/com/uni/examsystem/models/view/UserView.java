package com.uni.examsystem.models.view;

import com.uni.examsystem.models.entities.ExamEntity;
import com.uni.examsystem.models.entities.UserRoleEntity;

import java.util.HashSet;
import java.util.Set;

public class UserView {
    private String username;
    private String firstName;
    private String lastName;
    private String facNo;
    private Set<UserRoleEntity> roles = new HashSet<>();
    private Set<ExamEntity> exams;

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getFacNo() {return facNo;}

    public void setFacNo(String facNo) {this.facNo = facNo;}

    public Set<UserRoleEntity> getRoles() {return roles;}

    public void setRoles(Set<UserRoleEntity> roles) {this.roles = roles;}

    public Set<ExamEntity> getExams() {return exams;}

    public void setExams(Set<ExamEntity> exams) {this.exams = exams;}

}
