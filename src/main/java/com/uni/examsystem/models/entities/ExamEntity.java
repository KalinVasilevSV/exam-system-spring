package com.uni.examsystem.models.entities;

import com.uni.examsystem.models.entities.enums.ExamStatusEnum;

import javax.persistence.*;
import java.time.Duration;
import java.util.Set;

@Entity
@Table(name = "EXAMS")
public class ExamEntity extends BaseEntity {
    @Column(nullable = false)
    private String examName;
    @Column(nullable = false)
    private Duration timeGiven;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ExamStatusEnum status;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<QuestionEntity> questions;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserEntity> users;

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Duration getTimeGiven() {
        return timeGiven;
    }

    public void setTimeGiven(Duration timeGiven) {
        this.timeGiven = timeGiven;
    }

    public ExamStatusEnum getStatus() {return status;}

    public void setStatus(ExamStatusEnum status) {this.status = status;}

    public Set<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionEntity> questions) {
        this.questions = questions;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }
}
