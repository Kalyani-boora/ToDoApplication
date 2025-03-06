package com.example.ToDoApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ToDoApplication.Entity.ToDoEntity;

public interface ToDoRepository extends JpaRepository<ToDoEntity,Long> {

}