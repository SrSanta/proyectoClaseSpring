package org.iesbelen.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangoCatPlus implements ConstraintValidator<RangoCategoriaPlus, Integer> {
    protected int[] valuesValidos;
    protected int max;
    protected int min;

    @Override
    public void initialize(RangoCategoriaPlus constraintAnnotation) {
        valuesValidos = constraintAnnotation.values();
        max = constraintAnnotation.max();
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if (integer >= min && integer <= max) {
            for (int v : valuesValidos) {
                if (v == integer) {
                    return true;
                }
            }
        }

        return false;
    }
}
