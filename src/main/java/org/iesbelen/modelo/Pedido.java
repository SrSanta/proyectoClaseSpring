package org.iesbelen.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Comercial;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class Pedido {
    private int id;
    private double total;
    private LocalDate fecha;
    private Long idCliente;
    private int idComercial;
}