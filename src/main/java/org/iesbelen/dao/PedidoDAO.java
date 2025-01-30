package org.iesbelen.dao;

import org.iesbelen.modelo.Pedido;

import java.util.List;

public interface PedidoDAO {
    List<Pedido> findByComercialId(int comercialId);
}
