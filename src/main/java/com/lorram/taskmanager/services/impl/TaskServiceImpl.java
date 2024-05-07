package com.lorram.taskmanager.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lorram.taskmanager.dto.TaskDTO;
import com.lorram.taskmanager.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Override
	public Page<TaskDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDTO insert(TaskDTO task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDTO update(TaskDTO task, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
}
