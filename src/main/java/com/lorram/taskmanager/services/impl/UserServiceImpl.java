package com.lorram.taskmanager.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.lorram.taskmanager.entities.Task;
import com.lorram.taskmanager.services.TaskService;

@Service
public class UserServiceImpl implements TaskService {

	@Override
	public Page<Task> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Long id, Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
}
