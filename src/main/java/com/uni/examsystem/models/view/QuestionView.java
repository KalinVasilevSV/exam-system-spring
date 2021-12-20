package com.uni.examsystem.models.view;

import com.uni.examsystem.models.entities.AnswerSetEntity;
import com.uni.examsystem.models.entities.QuestionEntity;
import com.uni.examsystem.models.entities.enums.QuestionTypeEnum;

public class QuestionView {

    private Long id;
    private String question;
    private QuestionTypeEnum qType;
    private float score;
    private AnswerSetView answerSet;

    public QuestionView(){}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getQuestion() {return question;}

    public void setQuestion(String question) {this.question = question;}

    public QuestionTypeEnum getqType() {return qType;}

    public void setqType(QuestionTypeEnum qType) {this.qType = qType;}

    public float getScore() {return score;}

    public void setScore(float score) {this.score = score;}

    public AnswerSetView getAnswerSet() {return answerSet;}

    public void setAnswerSet(AnswerSetView answerSet) {this.answerSet = answerSet;}
}
