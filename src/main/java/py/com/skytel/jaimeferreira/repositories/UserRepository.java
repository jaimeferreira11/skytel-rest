package py.com.skytel.jaimeferreira.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.skytel.jaimeferreira.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	Optional<UserEntity> findByEmail(String email);

}
