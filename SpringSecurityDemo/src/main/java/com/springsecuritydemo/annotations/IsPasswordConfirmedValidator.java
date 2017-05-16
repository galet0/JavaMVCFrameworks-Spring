package com.springsecuritydemo.annotations;

import com.springsecuritydemo.models.RegisterModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class IsPasswordConfirmedValidator implements ConstraintValidator<IsPasswordConfirmed, Object> {
    @Override
    public void initialize(IsPasswordConfirmed isPasswordConfirmed) {

    }

    @Override
    public boolean isValid(Object userClass, ConstraintValidatorContext constraintValidatorContext) {
        if(userClass instanceof RegisterModel) {
            String password = ((RegisterModel) userClass).getPassword();
            String confirmPassword = ((RegisterModel) userClass).getConfirmPassword();
            return confirmPassword.equals(password);
        }
        return false;
    }
}
