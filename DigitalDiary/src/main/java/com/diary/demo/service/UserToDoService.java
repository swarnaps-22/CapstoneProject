package com.diary.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.demo.model.ToDo;
import com.diary.demo.repositories.ToDoRepository;

@Service
public class UserToDoService {
	@Autowired
	private ToDoRepository todoRepository;
	 public List<ToDo> getAllToDo() {
		 List<ToDo> toDo = new ArrayList<ToDo>();
		 todoRepository.findAll().forEach(toDo::add);
		 return toDo;
}
	 public void createToDo(ToDo toDoCreated)
	 {
		
		 todoRepository.save(toDoCreated);
	 }
	 
}
