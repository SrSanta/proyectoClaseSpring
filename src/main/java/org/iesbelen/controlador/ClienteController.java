package org.iesbelen.controlador;

import java.util.List;

import org.iesbelen.modelo.Cliente;
import org.iesbelen.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
//@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/clientes")
	public String listar(Model model) {
		
		List<Cliente> listaClientes =  clienteService.listAll();
		model.addAttribute("listaClientes", listaClientes);
				
		return "clientes";
		
	}
}