package com.uni.examsystem.models.validator;

import com.uni.examsystem.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueFacNumberValidator implements ConstraintValidator<UniqueFacNumber, String> {

    private final UserService userService;

    public UniqueFacNumberValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String facNumber, ConstraintValidatorContext context) {
        if (facNumber == null) {
            return true;
        }

        return userService.isFacNumFree(facNumber);
    }
}
