package org.iesbelen.controlador;

import java.util.List;

import jakarta.validation.Valid;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/cliente")
@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("")
	public String listar(Model model) {
		
		List<Cliente> listaClientes =  clienteService.listAll();
		model.addAttribute("listaClientes", listaClientes);
				
		return "clientes/clientes";
		
	}

	@GetMapping("/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {

		Cliente cliente = clienteService.one(id);
		model.addAttribute("cliente", cliente);

		return "clientes/detalleCliente";

	}

	@GetMapping("/crear")
	public String crear(Model model) {

		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);

		return "clientes/crearCliente";

	}

	@PostMapping("/crear")
	public String submitCrear(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result) {

		if (!result.hasErrors()) {
			clienteService.newCliente(cliente);
			return "redirect:/cliente";
		}

		return "clientes/crearCliente";
	}

	@GetMapping("/editar/{id}")
	public String editar(Model model, @PathVariable Integer id) {

		Cliente cliente = clienteService.one(id);
		model.addAttribute("cliente", cliente);

		return "clientes/editarCliente";

	}


	@PostMapping("/editar/{id}")
	public String submitEditar(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result) {

		if (!result.hasErrors()) {
			clienteService.replaceCliente(cliente);
			return "redirect:/cliente";
		}

		return "clientes/editarCliente";
	}

	@PostMapping("/borrar/{id}")
	public String submitBorrar(@PathVariable Integer id) {

		clienteService.deletecliente(id);

		return "redirect:/cliente";
	}
}