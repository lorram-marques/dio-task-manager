package com.lorram.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lorram.taskmanager.entities.User;

@Repository
public interface UserRepository extends JpaRepository<Long, User> {

}
