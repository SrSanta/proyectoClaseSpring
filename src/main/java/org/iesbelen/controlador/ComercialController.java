
package org.iesbelen.controlador;

import org.iesbelen.modelo.Comercial;
import org.iesbelen.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ComercialController {
    @Autowired
    private ComercialService comercialService;

    @GetMapping("/comerciales")
    public String listar(Model model) {

        List<Comercial> listaComercial =  comercialService.listAll();
        model.addAttribute("listaComerciales", listaComercial);

        return "comerciales";
    }
}
