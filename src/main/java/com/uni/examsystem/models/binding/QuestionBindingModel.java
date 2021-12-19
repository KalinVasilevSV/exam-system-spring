package com.uni.examsystem.models.binding;

import com.uni.examsystem.models.entities.AnswerSetEntity;
import com.uni.examsystem.models.entities.enums.QuestionTypeEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class QuestionBindingModel {
    @NotBlank
    private String question;
    @NotNull
    @Enumerated(EnumType.STRING)
    private QuestionTypeEnum qType;
    @NotNull
    @Positive
    private float score;
    @NotNull
    private AnswerSetEntity answerSet;

    public String getQuestion() {return question;}

    public void setQuestion(String question) {this.question = question;}

    public QuestionTypeEnum getqType() {return qType;}

    public void setqType(QuestionTypeEnum qType) {this.qType = qType;}

    public float getScore() {return score;}

    public void setScore(float score) {this.score = score;}

    public AnswerSetEntity getAnswerSet() {return answerSet;}

    public void setAnswerSet(AnswerSetEntity answerSet) {this.answerSet = answerSet;}
}
