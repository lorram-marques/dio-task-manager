package com.lorram.taskmanager.dto;

import java.io.Serializable;

import com.lorram.taskmanager.entities.Task;

public class TaskDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private String description;
	private Long ownerId;
	
	public TaskDTO() {
	}

	public TaskDTO(Long id, String title, String description, Long ownerId) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.ownerId = ownerId;
	}
	
	public TaskDTO(Task entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.description = entity.getDescription();
		this.ownerId = entity.getOwner().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
}
