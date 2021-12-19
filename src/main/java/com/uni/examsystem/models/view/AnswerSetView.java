package com.uni.examsystem.models.view;

import com.uni.examsystem.models.entities.QuestionEntity;
import com.uni.examsystem.models.entities.enums.AnswerEnum;

public class AnswerSetView {
    private String a;
    private String b;
    private String c;
    private AnswerEnum answer;
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
