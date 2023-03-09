package com.example.demoProject;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = TransactionValidator.class)
public @interface ValidateTransactionDescription
{

    public  String message()default "Invalid:you have to enter sample or example";
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
