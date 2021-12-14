package com.uni.examsystem.models.entities;

import com.uni.examsystem.models.entities.enums.QuestionTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "QUESTIONS")
public class QuestionEntity extends BaseEntity{
    @Column(nullable = false)
    private String question;
    @Column(nullable = false)
    private QuestionTypeEnum qType;
    @Column(nullable = false)
    private float score;
    @ManyToOne
    private AnswerSetEntity answerSet;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionTypeEnum getqType() {
        return qType;
    }

    public void setqType(QuestionTypeEnum qType) {
        this.qType = qType;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public AnswerSetEntity getAnswerSet() {
        return answerSet;
    }

    public void setAnswerSet(AnswerSetEntity answerSet) {
        this.answerSet = answerSet;
    }
}
