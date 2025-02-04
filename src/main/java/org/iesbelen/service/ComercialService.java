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
        pedidos.sort((a, b) -> b.getFecha().compareTo(a.getFecha()));

        List<PedidoDTO> pedidosDTO = new ArrayList<>();

        pedidos.forEach(p -> {
            long idC = p.getId_cliente();
            String nombre = clientes.stream()
                    .filter(c -> c.getId() == idC)
                    .map(c -> c.getNombre() + " " + c.getApellido1() + " " + (c.getApellido2() != null ? c.getApellido2() : ""))
                    .findFirst().orElse("");

            pedidosDTO.add(pedidoMapper.pedidoAPedidoDTO(p, nombre, ""));
        });

        return pedidosDTO;
    }

    public int getTotalPedidos() {
        return pedidoDAO.getTotalPedidos();
    }

    public double getPorcentajePedidos(int idComercial) {
        return (double)listPedidosDTO(idComercial).size() / getTotalPedidos() * 100;
    }
}