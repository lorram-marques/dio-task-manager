package com.lorram.taskmanager.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lorram.taskmanager.dto.TaskDTO;

public interface TaskService {

	Page<TaskDTO> findAll(Pageable pageable);

	TaskDTO findById(Long id);

	TaskDTO insert(TaskDTO task);

	TaskDTO update(Long id, TaskDTO task);

	void delete(Long id);
}
