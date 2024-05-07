package com.lorram.taskmanager.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lorram.taskmanager.dto.UserDTO;
import com.lorram.taskmanager.entities.User;
import com.lorram.taskmanager.repositories.UserRepository;
import com.lorram.taskmanager.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	
	public Page<UserDTO> findAll(Pageable pageable) {
		Page<User> list = repository.findAll(pageable);
		return list.map(x -> new UserDTO(x));
	}
	
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User user = obj.orElseThrow(() -> new RuntimeException()); //TODO ResourceNotFoundException
		return new UserDTO(user);
	}
	
	public UserDTO update(Long id, UserDTO dto) {
		User entity = repository.getReferenceById(id);
		fromDto(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		try {
		fromDto(dto, entity);
		entity = repository.save(entity);
		} catch(DataIntegrityViolationException e) {
			
			throw new RuntimeException("Integrity violation"); //TODO DatabaseException
		}
		return new UserDTO(entity);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
			} 
		catch (EmptyResultDataAccessException e) {
			throw new RuntimeException(); //TODO DatabaseException
		}
	}
	
	private void fromDto(UserDTO userDto, User entity) {
		entity.setName(userDto.getName());
		entity.setEmail(userDto.getEmail());
	}
}
