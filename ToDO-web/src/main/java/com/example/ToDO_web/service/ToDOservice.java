package com.example.ToDO_web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDO_web.model.ToDo;
import com.example.ToDO_web.repo.IToDorepo;

@Service
public class ToDOservice {

	@Autowired
	IToDorepo repo;
	
	 public List<ToDo> getAllToDoItems(){
		ArrayList<ToDo> todoList = new ArrayList<>();
		repo.findAll().forEach(todo -> todoList.add(todo));
		return todoList;
	}
	public ToDo getToDoitemsById(Long id) {
		return repo.findById(id).get();
		
	}
	public boolean updateStatus(Long id) {
		
		ToDo todo=getToDoitemsById(id);
		todo.setStatus("Completed");
		return saveOrUpdateToDoItems(todo);
		
		
		
	}
	public boolean saveOrUpdateToDoItems(ToDo todo) {
		ToDo updatedObj= repo.save(todo);
		if(getToDoitemsById(updatedObj.getId())!=null) {
			return true;
		}
		return false;
		
		
	}
	public boolean deleteToDoItems(Long id) {
		repo.deleteById(id);
		if(repo.findById(id).isEmpty()) {
			return true;
		}
		return false;
		
	}
}
