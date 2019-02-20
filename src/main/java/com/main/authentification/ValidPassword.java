package com.main.authentification;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomPasswordValidator.class)
public @interface ValidPassword {

    String message() default "Пароль должен содержать " +
        " одну заглавную букву, одну маленькую и одну цифру";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

