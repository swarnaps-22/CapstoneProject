package com.diary.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.demo.model.ToDo;
import com.diary.demo.model.ToDoItems;
import com.diary.demo.repositories.ToDoRepository;

@Service
public class UserToDoService {
	@Autowired
	private ToDoRepository todoRepository;
	 public List<ToDo> getAllToDo() {
		 List<ToDo> toDoList = new ArrayList<ToDo>();
		 todoRepository.findAll().forEach(toDoList::add);
		 return toDoList;
}
	 public Long findIdByDescription(String name) 
	 {
		 Long toDoId = 0L;
		 List<ToDo> toDoList = getAllToDo();
		for(ToDo item : toDoList)
		{
			if(item.getDescription().equals(name))
			{
				 toDoId = item.getTodo_Id();
				
			}
			
		}
		 return toDoId;
	 }
	 public void createToDo(ToDo toDoCreated)
	 {
		
		 todoRepository.save(toDoCreated);
	 }
	 
}
