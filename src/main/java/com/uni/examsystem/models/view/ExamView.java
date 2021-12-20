package com.uni.examsystem.models.view;

import com.uni.examsystem.models.entities.QuestionEntity;
import com.uni.examsystem.models.entities.UserEntity;
import com.uni.examsystem.models.entities.enums.ExamStatusEnum;

import java.time.Duration;
import java.util.Set;

public class ExamView {
    private Long id;
    private String name;
    private Duration timeGiven;
    private ExamStatusEnum status;

    private Set<QuestionEntity> questions;
    private Set<UserEntity> users;

    public ExamView() {
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public ExamStatusEnum getStatus() {return status;}

    public void setStatus(ExamStatusEnum status) {this.status = status;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Duration getTimeGiven() {return timeGiven;}

    public void setTimeGiven(Duration timeGiven) {this.timeGiven = timeGiven;}

    public Set<QuestionEntity> getQuestions() {return questions;}

    public void setQuestions(Set<QuestionEntity> questions) {this.questions = questions;}

    public Set<UserEntity> getUsers() {return users;}

    public void setUsers(Set<UserEntity> users) {this.users = users;}
}
