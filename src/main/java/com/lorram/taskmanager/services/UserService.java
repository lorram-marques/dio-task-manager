package com.lorram.taskmanager.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lorram.taskmanager.dto.UserDTO;

public interface UserService {

	Page<UserDTO> findAll(Pageable pageable);

	UserDTO findById(Long id);

	UserDTO insert(UserDTO user);

	UserDTO update(Long id, UserDTO user);

	void delete(Long id);
}
