package org.iesbelen.controlador;

import jakarta.validation.Valid;
import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequestMapping("/comercial")
@Controller
public class ComercialController {

    @Autowired
    private ComercialService comercialService;

    @GetMapping("")
    public String listar(Model model) {

        List<Comercial> listaComercial =  comercialService.listAll();
        model.addAttribute("listaComerciales", listaComercial);

        return "comerciales/comerciales";
    }

    @GetMapping("/{id}")
    public String detalle(Model model, @PathVariable Integer id ) {

        Comercial comercial = comercialService.one(id);
        model.addAttribute("comercial", comercial);

        List<PedidoDTO> pedidosDTO = comercialService.listPedidosDTO(id);
        model.addAttribute("pedidosDTO", pedidosDTO);

        int cantidadPedidos = comercialService.getTotalPedidos();
        model.addAttribute("cantidadPedidos", cantidadPedidos);

        double media = comercialService.getPorcentajePedidos(id);
        model.addAttribute("media", media);
        return "comerciales/detalleComercial";
    }

    @GetMapping("/crear")
    public String crear(Model model) {

        Comercial comercial = new Comercial();
        model.addAttribute("comercial", comercial);

        return "comerciales/crearComercial";

    }

    @PostMapping("/crear")
    public String submitCrear(@Valid @ModelAttribute("comercial") Comercial comercial, BindingResult result) {

        if (!result.hasErrors()) {
            comercialService.newComercial(comercial);
            return "redirect:/comercial";
        }

        return "comerciales/crearComercial";

    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable Integer id) {

        Comercial comercial = comercialService.one(id);
        model.addAttribute("comercial", comercial);

        return "comerciales/editarComercial";

    }


    @PostMapping("/editar/{id}")
    public String submitEditar(@Valid @ModelAttribute("comercial") Comercial comercial, BindingResult result) {

        if (!result.hasErrors()) {
            comercialService.replaceComercial(comercial);
            return "redirect:/comercial";
        }

        return "comerciales/editarComercial";
    }

    @PostMapping("/borrar/{id}")
    public String submitBorrar(@PathVariable Integer id) {

        comercialService.deleteComercial(id);

        return "redirect:/comercial";
    }
}
