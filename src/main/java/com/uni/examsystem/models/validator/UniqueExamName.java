package com.uni.examsystem.models.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueExamNameValidator.class)
public @interface UniqueExamName {

    String message() default "Exam Name is not unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
