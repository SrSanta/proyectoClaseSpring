package org.iesbelen.modelo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesbelen.validator.RangoCategoria;
import org.iesbelen.validator.RangoCategoriaPlus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
	
	private long id;

	@NotBlank(message = "{error}")
	@Size(max=30, message = "{error}")
	private String nombre;

	@NotBlank(message = "{error}")
	@Size(max=30, message = "{error}")
	private String apellido1;

	@NotBlank(message = "{error}")
	@Size(max=30, message = "{error}")
	private String apellido2;

	@NotBlank(message = "{error}")
	@Size(max=50, message = "{error}")
	private String ciudad;

	@NotNull(message = "Por favor, introduzca categoria.")
//	@Min(value=100, message = "Salario debe ser al menos de 100.")
//	@Max(value=1000, message = "Salario no debe ser mayor de 1000.")

	@RangoCategoriaPlus(values = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000},
			min = 100,
			max=1000)
	private int categoria;

//	@Email(message = "Formato de email incorrecto", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
//	//@NotBlank(message = "Por favor, introduzca email.")
//	private String email;

}
