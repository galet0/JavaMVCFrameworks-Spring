package com.springsecuritydemo.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = IsPasswordConfirmedValidator.class)
public @interface IsPasswordConfirmed {

    String message() default "Passwords not matching";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}
