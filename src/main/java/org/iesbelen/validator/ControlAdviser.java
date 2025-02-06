package org.iesbelen.validator;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControlAdviser {
    @ExceptionHandler(MiExcepcion.class)
    public String handleMiException(Model model, MiExcepcion miExcepcion){
        model.addAttribute("mensajeError", miExcepcion.getMessage());

        return "error";
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleAllUncauhhtException(Model model, RuntimeException exception){
        model.addAttribute("mensajeError", exception.getMessage());

        return "error";
    }
}
