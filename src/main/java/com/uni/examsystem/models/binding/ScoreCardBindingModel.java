package com.uni.examsystem.models.binding;

import com.uni.examsystem.models.entities.ExamEntity;
import com.uni.examsystem.models.entities.UserEntity;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class ScoreCardBindingModel {
    @NotNull
    private ExamEntity exam;
    @NotNull
    private UserEntity user;
    private float score;
    private Timestamp startTimestamp;
    private Timestamp endTimestamp;

    public ExamEntity getExam() {return exam;}

    public void setExam(ExamEntity exam) {this.exam = exam;}

    public UserEntity getUser() {return user;}

    public void setUser(UserEntity user) {this.user = user;}

    public float getScore() {return score;}

    public void setScore(float score) {this.score = score;}

    public Timestamp getStartTimestamp() {return startTimestamp;}

    public void setStartTimestamp(Timestamp startTimestamp) {this.startTimestamp = startTimestamp;}

    public Timestamp getEndTimestamp() {return endTimestamp;}

    public void setEndTimestamp(Timestamp endTimestamp) {this.endTimestamp = endTimestamp;}
}
