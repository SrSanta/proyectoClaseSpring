package org.iesbelen.service;

import org.iesbelen.dao.ClienteDAO;
import org.iesbelen.dao.ComercialDAO;
import org.iesbelen.dao.PedidoDAO;
import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.mapstruct.PedidoMapper;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ComercialService {
    @Autowired
    private ComercialDAO comercialDAO;
    @Autowired
    private PedidoDAO pedidoDAO;
    @Autowired
    private ClienteDAO clienteDAO;
    @Autowired
    private PedidoMapper pedidoMapper;

    public List<Comercial> listAll() {

        return comercialDAO.getAll();

    }

    public Comercial one(Integer id) {
        Optional<Comercial> optFab = comercialDAO.find(id);
        if (optFab.isPresent())
            return optFab.get();
        else
            return null;
    }

    public void newComercial(Comercial comercial) {

        comercialDAO.create(comercial);

    }

    public void replaceComercial(Comercial comercial) {

        comercialDAO.update(comercial);

    }

    public void deleteComercial(int id) {

        comercialDAO.delete(id);

    }

    public List<PedidoDTO> listPedidosDTO(int idComercial) {
        List<Cliente> clientes = clienteDAO.getAll();
        List<Pedido> pedidos = pedidoDAO.getAllByComercial(idComercial);

        // Mapa para acceder rápidamente a los clientes por su ID
        Map<Long, String> clienteMap = clientes.stream()
                .collect(Collectors.toMap(
                        Cliente::getId,
                        c -> c.getNombre() + " " + c.getApellido1() +
                                (c.getApellido2() != null ? " " + c.getApellido2() : "")
                ));

        return pedidos.stream()
                .sorted(Comparator.comparing(Pedido::getFecha).reversed()) // Ordenar por fecha descendente
                .map(p -> pedidoMapper.pedidoAPedidoDTO(
                        p,
                        clienteMap.getOrDefault(p.getIdCliente(), "Desconocido"),
                        ""
                ))
                .collect(Collectors.toList());
    }
}