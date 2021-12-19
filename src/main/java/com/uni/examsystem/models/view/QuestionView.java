package com.uni.examsystem.models.view;

import com.uni.examsystem.models.entities.AnswerSetEntity;
import com.uni.examsystem.models.entities.enums.QuestionTypeEnum;

public class QuestionView {
    private String question;
    private QuestionTypeEnum qType;
    private float score;
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
