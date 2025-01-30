package org.iesbelen.dao;

import org.iesbelen.modelo.Pedido;

import java.util.List;

public interface PedidoDAO {
    public List<Pedido> getAll();
    public List<Pedido> getAllByComercial(int idComercial);
    public List<Pedido> getAllByCliente(int idCliente);
    public void delete(int id);

    public Integer getTotalPedido();
}
