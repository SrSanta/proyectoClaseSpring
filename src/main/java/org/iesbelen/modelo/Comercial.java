package org.iesbelen.modelo;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comercial {

	private int id;

	@NotBlank(message = "{error}")
	@Size(max=30, message = "{error}")
	private String nombre;

	@NotBlank(message = "{error}")
	@Size(max=30, message = "{error}")
	private String apellido1;

	@NotBlank(message = "{error}")
	@Size(max=30, message = "{error}")
	private String apellido2;

	@DecimalMin(value = "0.276", inclusive = true, message = "{error}")
	@DecimalMax(value = "0.946", inclusive = true, message = "{error}")
	private BigDecimal comision;

}
