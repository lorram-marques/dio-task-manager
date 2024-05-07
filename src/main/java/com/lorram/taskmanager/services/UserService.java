package com.lorram.taskmanager.services;

import org.springframework.data.domain.Page;

import com.lorram.taskmanager.entities.User;

public interface UserService {

	Page<User> findAll();

	User findById(Long id);

	void insert(User user);

	void update(Long id, User user);

	void delete(Long id);
}
