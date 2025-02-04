package org.iesbelen.validator;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class RangoCat implements ConstraintValidator<RangoCategoria, Integer> {

    @Override
    public boolean isValid(Integer categoria, ConstraintValidatorContext constraintValidatorContext) {
        List<Integer> categoriaValidas = List.of(100, 200, 300, 400, 500, 600, 700, 800, 1000);

        return categoria != null && categoriaValidas.contains(categoria);
    }
}
