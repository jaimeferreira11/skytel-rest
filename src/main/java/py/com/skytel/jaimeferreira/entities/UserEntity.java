package py.com.skytel.jaimeferreira.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "El nombre es requerido")
	private String name;

	@NotNull(message = "El apellido es requerido")
	private String lastName;

	@NotNull(message = "El telefono es requerido")
	@Size(min = 5, max = 10, message = "El telefono debe tener una longitud entre 5 a 10 caracteres")
	private String phoneNumber;

	@NotNull(message = "El email es requerido")
	@Email(message = "Debe ser un email valido")
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (id == null || obj == null || getClass() != obj.getClass()) {
			return false;
		}
		UserEntity toCompare = (UserEntity) obj;
		return id.equals(toCompare.id);
	}

}
