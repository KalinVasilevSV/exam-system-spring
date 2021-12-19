package com.uni.examsystem.models.validator;

import com.uni.examsystem.service.ExamService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueExamNameValidator implements ConstraintValidator<UniqueExamName,String > {
    private final ExamService examService;

    public UniqueExamNameValidator(ExamService examService){
        this.examService=examService;
    }
//TODO
    //implement methods
    @Override
    public boolean isValid(String examname, ConstraintValidatorContext context) {
        return examService.isExamNameFree(examname);
    }
}
