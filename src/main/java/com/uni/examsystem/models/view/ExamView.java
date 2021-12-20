package com.uni.examsystem.models.view;

import com.uni.examsystem.models.entities.ExamEntity;
import com.uni.examsystem.models.entities.QuestionEntity;
import com.uni.examsystem.models.entities.UserEntity;
import com.uni.examsystem.models.entities.enums.ExamStatusEnum;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ExamView {
    private Long id;
    private String examName;
    private Duration timeGiven;
    private ExamStatusEnum status;

    private Set<QuestionView> questions = new HashSet<>();
    private Set<UserDetailsView> users=new HashSet<>();

    public ExamView() {
    }
    public ExamView(ExamEntity examEntity){
        this.id=examEntity.getId();
        this.examName=examEntity.getExamName();
        this.timeGiven=examEntity.getTimeGiven();
        this.status=examEntity.getStatus();
        this.questions=examEntity.getQuestions().stream().map(questionEntity -> {
            var questionView = new QuestionView(questionEntity);
            return questionView;
        }).collect(Collectors.toSet());
        this.users=examEntity.getUsers().stream().map(userEntity -> {
            var userDetailsView = new UserDetailsView(userEntity);
            return userDetailsView;
        }).collect(Collectors.toSet());
    }
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public ExamStatusEnum getStatus() {return status;}

    public void setStatus(ExamStatusEnum status) {this.status = status;}

    public String getExamName() {return examName;}

    public void setExamName(String examName) {this.examName = examName;}

    public Duration getTimeGiven() {return timeGiven;}

    public void setTimeGiven(Duration timeGiven) {this.timeGiven = timeGiven;}

    public Set<QuestionView> getQuestions() {return questions;}

    public void setQuestions(Set<QuestionView> questions) {this.questions = questions;}

    public Set<UserDetailsView> getUsers() {return users;}

    public void setUsers(Set<UserDetailsView> users) {this.users = users;}
}
