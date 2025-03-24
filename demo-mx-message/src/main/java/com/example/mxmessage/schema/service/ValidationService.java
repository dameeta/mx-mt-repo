package com.example.mxmessage.schema.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ValidationService {
private final Validator validator;

    public ValidationService() {
        ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public <T>Set<ConstraintViolation<T>> validate(T object)
    {
        return validator.validate(object);
    }
}

