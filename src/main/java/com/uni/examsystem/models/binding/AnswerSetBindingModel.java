package com.uni.examsystem.models.binding;

import com.uni.examsystem.models.entities.QuestionEntity;
import com.uni.examsystem.models.entities.enums.AnswerEnum;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//TODO not used, may be removed
public class AnswerSetBindingModel {
    @NotBlank
    private String a;
    @NotBlank
    private String b;
    @NotBlank
    private String c;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AnswerEnum answer;
    @NotNull
    @OneToMany
    private QuestionEntity question;

    public String getA() {return a;}

    public void setA(String a) {this.a = a;}

    public String getB() {return b;}

    public void setB(String b) {this.b = b;}

    public String getC() {return c;}

    public void setC(String c) {this.c = c;}

    public AnswerEnum getAnswer() {return answer;}

    public void setAnswer(AnswerEnum answer) {this.answer = answer;}

    public QuestionEntity getQuestion() {return question;}

    public void setQuestion(QuestionEntity question) {this.question = question;}
}
