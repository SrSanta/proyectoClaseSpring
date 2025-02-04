package org.iesbelen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PedidoDTO {
    private int id;
    private double total;
    private LocalDate fecha;
    private int id_cliente;
    private int id_comercial;

    private String nombreCliente;
    private String nombreComercial;
}