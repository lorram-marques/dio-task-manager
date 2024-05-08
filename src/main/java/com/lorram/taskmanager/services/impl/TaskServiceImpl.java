package com.lorram.taskmanager.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lorram.taskmanager.dto.TaskDTO;
import com.lorram.taskmanager.entities.Task;
import com.lorram.taskmanager.entities.User;
import com.lorram.taskmanager.repositories.TaskRepository;
import com.lorram.taskmanager.repositories.UserRepository;
import com.lorram.taskmanager.services.TaskService;
import com.lorram.taskmanager.services.exceptions.DatabaseException;
import com.lorram.taskmanager.services.exceptions.ResourceNotFoundException;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Page<TaskDTO> findAll(Pageable pageable) {
		Page<Task> list = repository.findAll(pageable);
		return list.map(x -> new TaskDTO(x));
	}
	
	public TaskDTO findById(Long id) {
		Optional<Task> obj = repository.findById(id);
		Task task = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new TaskDTO(task);
	}
	
	public TaskDTO update(Long id, TaskDTO dto) {
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
			throw new DatabaseException("Integrity violation");
		}
		return new TaskDTO(entity);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new DatabaseException("Integrity violation");
			}
	}
	
	private void fromDto(TaskDTO taskDto, Task entity) {
		entity.setTitle(taskDto.getTitle());
		entity.setDescription(taskDto.getDescription());
		User owner = entity.getOwner();
		if (owner == null) {
			entity.setOwner(userRepository.getReferenceById(taskDto.getOwnerId()));
		} else {  
			entity.setOwner(entity.getOwner());
		}
		entity.setCompleted(taskDto.isCompleted());
	}
}
