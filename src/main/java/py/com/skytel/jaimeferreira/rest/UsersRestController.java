package py.com.skytel.jaimeferreira.rest;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import py.com.skytel.jaimeferreira.dtos.UserDTO;
import py.com.skytel.jaimeferreira.services.UserService;
import py.com.skytel.jaimeferreira.utils.JWTGenerator;

@RestController
@RequestMapping(value = "/api/v1/users")
@Validated
public class UsersRestController {

	private UserService userService;

	public UsersRestController(UserService userService) {
		this.userService = userService;
	}

	@ApiOperation(value = "Registra un nuevo usuario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario creado correctamente"),
			@ApiResponse(code = 400, message = "El body es requerido"),
			@ApiResponse(code = 403, message = "Ya existe un usuario con ese email"),
			@ApiResponse(code = 409, message = "El email no puede ser igual a john@smith.com"),
			@ApiResponse(code = 500, message = "Error interno") })
	@PostMapping("/register")
	public ResponseEntity<String> agregarUsuario(@Valid @RequestBody UserDTO user) {
		
		
		return new ResponseEntity<String>(JWTGenerator.createJWT(userService.save(user)), HttpStatus.OK);

	}

}