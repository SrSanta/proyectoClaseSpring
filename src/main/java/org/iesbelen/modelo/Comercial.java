package org.iesbelen.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.iesbelen.dao.ComercialDAO;

@Data
@AllArgsConstructor
public class Comercial {

	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private float comision;

	public Comercial(){}
}
