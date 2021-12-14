package com.uni.examsystem.models.entities;

import com.uni.examsystem.models.entities.enums.AnswerEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ANSWER_SETS")
public class AnswerSetEntity extends BaseEntity{
    @Column(nullable = false)
    private String a;
    @Column(nullable = false)
    private String b;
    @Column(nullable = false)
    private String c;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AnswerEnum answer;
    @OneToOne
    private QuestionEntity question;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public AnswerEnum getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerEnum answer) {
        this.answer = answer;
    }
}
