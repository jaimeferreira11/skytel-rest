package py.com.skytel.jaimeferreira.dtos;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Este modelo respresenta un usuario")
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "id", required = false, example = "1", value = "Identificador unico del usuario")
	private Integer id;

	@ApiModelProperty(name = "name", required = true, example = "Jhon", value = "Nombre del usuario (entre 1 - 50 caracteres)")
	private String name;

	@ApiModelProperty(name = "lastName", required = true, example = "Doe", value = "Apellido del usuario (entre 1 - 50 caracteres)")
	private String lastName;

	@ApiModelProperty(name = "phoneNumber", required = false, example = "098123445", value = "Numero de telefono del usuario (entre 5 - 10 dígitos)")
	private String phoneNumber;

	@ApiModelProperty(name = "email", required = true, example = "ejemplo@ejemplo.com", value = "Dirección del usuario (formato email)")
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
