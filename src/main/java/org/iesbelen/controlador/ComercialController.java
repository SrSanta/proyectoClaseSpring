package org.iesbelen.controlador;

import jakarta.validation.Valid;
import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.modelo.Pedido;
import org.iesbelen.service.ClienteService;
import org.iesbelen.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ComercialController {
    @Autowired
    private ComercialService comercialService;
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/comerciales")
    public String listar(Model model) {
        List<Comercial> listaComercial = comercialService.listAll();
        model.addAttribute("listaComerciales", listaComercial);
        return "/comerciales/comerciales";
    }

    @GetMapping("/comerciales/{id}")
    public String detalle(Model model, @PathVariable Integer id ) {

        Comercial comercial = comercialService.one(id);
        model.addAttribute("comercial", comercial);

        List<PedidoDTO> pedidosDTO = comercialService.listPedidosDTO(id);
        model.addAttribute("pedidosDTO", pedidosDTO);

        Integer totalPedidos = comercialService.totalPedidosDTO();
        model.addAttribute("totalPedidos", totalPedidos);

        Double mediaPedidos = comercialService.getPorcentajePedidos(id);
        model.addAttribute("mediaPedidos", mediaPedidos);
        return "/comerciales/detalleComercial";
    }

    @GetMapping("/comerciales/crear")
    public String crear(Model model) {
        model.addAttribute("comercial", new Comercial());
        return "/comerciales/crearComercial";
    }

    @PostMapping("/comerciales/crear")
    public RedirectView submitCrear(@Valid @ModelAttribute Comercial comercial, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            comercialService.newComercial(comercial);
            return new RedirectView("/comerciales");
        }
        return new RedirectView("/comerciales/crear");
    }

    @GetMapping("/comerciales/editar/{id}")
    public String editar(Model model, @PathVariable Integer id) {
        Comercial comercial = comercialService.one(id);
        if (comercial == null) {
            throw new RuntimeException("Comercial no encontrado con ID: " + id);
        }
        model.addAttribute("comercial", comercial);
        return "/comerciales/editarComercial";
    }

    @PostMapping("/comerciales/editar/{id}")
    public RedirectView submitEditar(@ModelAttribute("comercial") Comercial comercial) {
        comercialService.replaceComercial(comercial);
        return new RedirectView("/comerciales");
    }

    @PostMapping("/comerciales/borrar/{id}")
    public RedirectView submitBorrar(@PathVariable Integer id) {
        comercialService.deleteComercial(id);
        return new RedirectView("/comerciales");
    }
}
