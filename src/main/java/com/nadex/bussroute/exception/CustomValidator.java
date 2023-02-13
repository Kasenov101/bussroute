package com.nadex.bussroute.exception;

import com.nadex.bussroute.dto.projection.RouteProjectionRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<RouteRange,RouteProjectionRequest> {
    @Override
    public boolean isValid(RouteProjectionRequest route, ConstraintValidatorContext context) {
        boolean hasViolation = false;
        context.disableDefaultConstraintViolation();
        if((route.from() <= 0)) {
            context.buildConstraintViolationWithTemplate("from must be greater than 0")
                    .addConstraintViolation();
            hasViolation = true;
        }
        if(route.to() <= 0) {
            context.buildConstraintViolationWithTemplate("to must be greater than 0")
                    .addConstraintViolation();
            hasViolation = true;
        }
        if (route.from() >= Integer.MAX_VALUE) {
            context.buildConstraintViolationWithTemplate(
                    String.format("from must be less than %s", "2 147 483 647"))
                    .addConstraintViolation();
            hasViolation = true;
        }
        if (route.to() >= Integer.MAX_VALUE) {
            context.buildConstraintViolationWithTemplate(
                            String.format("to must be less than %s", "2 147 483 647"))
                    .addConstraintViolation();
            hasViolation = true;
        }

        return !hasViolation;
    }
}
