package com.app.custodian.validation.Constraints;

import com.app.custodian.validation.Validators.MinFutureValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.time.temporal.ChronoUnit;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MinFutureValidator.class)
public @interface MinFuture{

    ChronoUnit unit();
    long amount();

    String message() default "min future validation failed";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
