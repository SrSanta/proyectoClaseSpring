package org.iesbelen.service;

import java.util.List;
import java.util.Optional;

import org.iesbelen.dao.ClienteDAO;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Comercial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteDAO clienteDAO;
	
	public List<Cliente> listAll() {
		
		return clienteDAO.getAll();
		
	}

	public Cliente one(Integer id) {
		Optional<Cliente> optCli = clienteDAO.find(id);
		if (optCli.isPresent())
			return optCli.get();
		else
			return null;
	}

	public void newCliente(Cliente cliente) {

		clienteDAO.create(cliente);

	}

	public void replaceCliente(Cliente cliente) {

		clienteDAO.update(cliente);

	}

	public void deletecliente(int id) {

		clienteDAO.delete(id);

	}

}
