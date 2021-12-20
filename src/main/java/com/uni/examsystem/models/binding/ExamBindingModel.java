package com.uni.examsystem.models.binding;

import com.uni.examsystem.models.entities.enums.ExamStatusEnum;
import com.uni.examsystem.models.validator.UniqueExamName;
import org.hibernate.validator.constraints.time.DurationMin;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Duration;

public class ExamBindingModel {

    private Long id;
    @NotBlank
    @UniqueExamName
    private String name;
    @NotNull
    @DurationMin(inclusive = true,minutes = 5)
    private Duration timeGiven;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ExamStatusEnum status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Duration getTimeGiven() {return timeGiven;}

    public void setTimeGiven(Duration timeGiven) {this.timeGiven = timeGiven;}

    public ExamStatusEnum getStatus() {return status;}

    public void setStatus(ExamStatusEnum status) {this.status = status;}
}
