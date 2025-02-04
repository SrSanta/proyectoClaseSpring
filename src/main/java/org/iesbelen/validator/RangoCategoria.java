package org.iesbelen.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RangoCat.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface RangoCategoria {
    String message() default "La categoría debe ser uno de los valores permitidos: 100, 200, 300, ..., 1000";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
