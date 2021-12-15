package com.uni.examsystem.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.Duration;
import java.util.Set;

@Entity
@Table(name = "EXAMS")
public class ExamEntity extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Duration timeGiven;
    @ManyToMany
    private Set<QuestionEntity> questions;
    @ManyToMany
    private  Set<UserEntity> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getTimeGiven() {
        return timeGiven;
    }

    public void setTimeGiven(Duration timeGiven) {
        this.timeGiven = timeGiven;
    }

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
