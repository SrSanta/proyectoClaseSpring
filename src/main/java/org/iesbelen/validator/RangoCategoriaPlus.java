package org.iesbelen.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {RangoCatPlus.class})
public @interface RangoCategoriaPlus {

    int[] values();

    int max();
    int min();

    public String message() default "La categoría del cliente no es valida. Debe ser mayor de 100 y menor de 1000, " +
            "además de ser un valor permitido como 100,200,300,400,500,600,700,800,900,1000";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
