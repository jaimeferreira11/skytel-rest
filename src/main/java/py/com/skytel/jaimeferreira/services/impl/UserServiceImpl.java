package py.com.skytel.jaimeferreira.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import py.com.skytel.jaimeferreira.dtos.UserDTO;
import py.com.skytel.jaimeferreira.entities.UserEntity;
import py.com.skytel.jaimeferreira.exceptions.ConflictException;
import py.com.skytel.jaimeferreira.exceptions.ForbiddenException;
import py.com.skytel.jaimeferreira.mapper.UserMapper;
import py.com.skytel.jaimeferreira.repositories.UserRepository;
import py.com.skytel.jaimeferreira.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepo;

	private final UserMapper userMapper;

	public UserServiceImpl(UserRepository userRepo, UserMapper userMapper) {
		this.userRepo = userRepo;
		this.userMapper = userMapper;
	}

	@Override
	public UserDTO save(UserDTO userDTO) {

		if(userDTO.getEmail().equalsIgnoreCase("john@smith.com"))
			throw new ConflictException("No se puede crear un usuario con el mail `john@smith.com` ");
		
		if (userRepo.findByEmail(userDTO.getEmail()).isPresent())
			throw new ForbiddenException("Ya existe un usuario con ese email");
		
	
		return userMapper.entityToDto(userRepo.save(userMapper.dtoToEntity(userDTO)));

	}

}
