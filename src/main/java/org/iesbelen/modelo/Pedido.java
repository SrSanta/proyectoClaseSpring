package org.iesbelen.modelo;

import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Comercial;

import java.util.Date;

public class Pedido {
    private int id;
    private double total;
    private Date fecha;
    private Cliente cliente;
    private Comercial comercial;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Comercial getComercial() { return comercial; }
    public void setComercial(Comercial comercial) { this.comercial = comercial; }
}