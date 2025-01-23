package org.iesbelen.service;

import java.util.List;

import org.iesbelen.dao.ClienteDAO;
import org.iesbelen.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	@Autowired
	private ClienteDAO clienteDAO;
	
	public List<Cliente> listAll() {
		
		return clienteDAO.getAll();
		
	}
	
	

}
