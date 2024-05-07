package com.lorram.taskmanager.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lorram.taskmanager.dto.UserDTO;

public interface UserService {

	Page<UserDTO> findAll(Pageable pageable);

	UserDTO findById(Long id);

	UserDTO insert(UserDTO user);

	UserDTO update(UserDTO user, Long id);

	void delete(Long id);
}
