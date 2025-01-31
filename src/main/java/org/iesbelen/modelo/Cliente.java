package org.iesbelen.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
	@NotBlank(message = "{cliente.error}")
	@Size(max = 30, message = "{cliente.error}")
	private String nombre;
	@NotBlank(message = "{cliente.error}")
	@Size(max = 30, message = "{cliente.error}")
	private String apellido1;
	private String apellido2;
	@NotBlank(message = "{cliente.error}")
	@Size(max = 50, message = "{cliente.error}")
	private String ciudad;
	@NotBlank(message = "{cliente.error}")
	@Size(min = 100,max = 1000, message = "{cliente.error}")
	private int categoria;
}
