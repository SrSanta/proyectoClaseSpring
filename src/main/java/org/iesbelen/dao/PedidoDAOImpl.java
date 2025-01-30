package org.iesbelen.dao;

import org.iesbelen.modelo.Pedido;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PedidoDAOImpl implements PedidoDAO {

    private final JdbcTemplate jdbcTemplate;

    public PedidoDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pedido> findByComercialId(int comercialId) {
        String sql = "SELECT * FROM pedido WHERE id_comercial = ?";
        return jdbcTemplate.query(sql, new PedidoRowMapper(), comercialId);
    }

    private static class PedidoRowMapper implements RowMapper<Pedido> {
        @Override
        public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
            Pedido pedido = new Pedido();
            pedido.setId(rs.getInt("id"));
            pedido.setTotal(rs.getDouble("total"));
            pedido.setFecha(rs.getDate("fecha"));
            // Aquí deberías cargar el Cliente y Comercial si es necesario
            return pedido;
        }
    }
}
