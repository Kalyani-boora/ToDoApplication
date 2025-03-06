package com.example.ToDoApplication.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoApplication.Entity.ToDoEntity;
import com.example.ToDoApplication.Repository.ToDoRepository;

@Service
public class ToDoServiceClass{
	@Autowired
	public ToDoRepository repo;

	public List<ToDoEntity> getAllToDoItems() {
		ArrayList<ToDoEntity> todoList = new ArrayList<>();
		repo.findAll().forEach(todo -> todoList.add(todo));
		
		return todoList;
	}
	
	public ToDoEntity getToDoItemById(Long id) {
		return repo.findById(id).get();
	}
	
	public boolean updateStatus(Long id) {
		ToDoEntity todo = getToDoItemById(id);
		todo.setStatus("Completed");
		return saveOrUpdateToDoItem(todo);
	}
	
	public boolean saveOrUpdateToDoItem(ToDoEntity todo) {
		ToDoEntity updatedObj = repo.save(todo);
		
		if (getToDoItemById(updatedObj.getId()) != null) {
			return true;
		}
		
		return false;
	}
	
	public boolean deleteToDoItem(Long id) {
		repo.deleteById(id);
		
		if (repo.findById(id).isEmpty()) {
			return true;
		}
		
		return false;
	}
	
}