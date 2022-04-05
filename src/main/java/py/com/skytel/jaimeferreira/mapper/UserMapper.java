package py.com.skytel.jaimeferreira.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.skytel.jaimeferreira.dtos.UserDTO;
import py.com.skytel.jaimeferreira.entities.UserEntity;

/**
 * Created by jdferrira
 */

@Component
public class UserMapper implements BaseMapper<UserEntity, UserDTO> {

	private final ModelMapper modelMapper;

	public UserMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public List<UserDTO> entityListToDtoList(List<UserEntity> entityList) {
		return entityList.stream().filter(Objects::nonNull).map(this::entityToDto).collect(Collectors.toList());
	}

	@Override
	public UserDTO entityToDto(UserEntity entity) {
		return modelMapper.map(entity, UserDTO.class);

	}

	@Override
	public UserEntity dtoToEntity(UserDTO dto) {
		return modelMapper.map(dto, UserEntity.class);
	}
}
