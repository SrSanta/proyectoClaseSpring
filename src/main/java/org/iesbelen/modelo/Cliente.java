package org.iesbelen.modelo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//La anotación @Data de lombok proporcionará el código de:
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	
	private long id;
	@NotBlank(message = "{error}")
	@Size(max = 30, message = "{error}")
	private String nombre;
	@NotBlank(message = "{error}")
	@Size(max = 30, message = "{error}")
	private String apellido1;
	private String apellido2;
	@NotBlank(message = "{error}")
	@Size(max = 50, message = "{error}")
	private String ciudad;
	@NotNull(message = "{error}")
	@Min(value = 100, message = "{error}")
	@Max(value = 1000, message = "{error}")
	private int categoria;

//	@Email()
//	private String email;
}
