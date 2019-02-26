package com.main.authentification;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginUniquenessValidator.class)
public @interface UniqueUser {
    String message() default "Пользователь с таким логином уже существует";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
