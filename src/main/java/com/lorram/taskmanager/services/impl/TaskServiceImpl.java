package com.lorram.taskmanager.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lorram.taskmanager.dto.TaskDTO;
import com.lorram.taskmanager.entities.Task;
import com.lorram.taskmanager.repositories.TaskRepository;
import com.lorram.taskmanager.repositories.UserRepository;
import com.lorram.taskmanager.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository repository;
	
	@Autowired UserRepository userRepository;
	
	
	public Page<TaskDTO> findAll(Pageable pageable) {
		Page<Task> list = repository.findAll(pageable);
		return list.map(x -> new TaskDTO(x));
	}
	
	public TaskDTO findById(Long id) {
		Optional<Task> obj = repository.findById(id);
		Task task = obj.orElseThrow(() -> new RuntimeException()); //TODO ResourceNotFoundException
		return new TaskDTO(task);
	}
	
	public TaskDTO update(TaskDTO dto, Long id) {
		Task entity = repository.getReferenceById(id);
		fromDto(dto, entity);
		entity = repository.save(entity);
		return new TaskDTO(entity);
	}

	public TaskDTO insert(TaskDTO dto) {
		Task entity = new Task();
		try {
		fromDto(dto, entity);
		entity = repository.save(entity);
		} catch(DataIntegrityViolationException e) {
			throw new RuntimeException("Integrity violation"); //TODO DatabaseException
		}
		return new TaskDTO(entity);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
			} 
		catch (EmptyResultDataAccessException e) {
			throw new RuntimeException();
		}
	}
	
	private void fromDto(TaskDTO taskDto, Task entity) {
		entity.setTitle(taskDto.getTitle());
		entity.setDescription(taskDto.getDescription());
		entity.setOwner(userRepository.getReferenceById(taskDto.getOwnerId()));
	}
}
