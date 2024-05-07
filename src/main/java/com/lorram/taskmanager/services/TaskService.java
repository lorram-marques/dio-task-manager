package com.lorram.taskmanager.services;

import org.springframework.data.domain.Page;

import com.lorram.taskmanager.entities.Task;

public interface TaskService {

	Page<Task> findAll();

	Task findById(Long id);

	void insert(Task task);

	void update(Long id, Task task);

	void delete(Long id);
}
