package com.example.demoProject;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class TransactionValidator implements ConstraintValidator<ValidateTransactionDescription,String> {
    @Override
    public boolean isValid(String transactionDescription, ConstraintValidatorContext context) {
        List<String> transactionDescriptions = Arrays.asList("sample","example");

        return transactionDescriptions.contains(transactionDescription);
    }
}
