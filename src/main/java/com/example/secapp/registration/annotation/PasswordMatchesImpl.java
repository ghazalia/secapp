package com.example.secapp.registration.annotation;

import com.example.secapp.registration.AccountDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesImpl
    implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {}

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        AccountDto user = (AccountDto) value;
        return user.getPassword().equals(user.getPasswordConfirm());
    }
}
