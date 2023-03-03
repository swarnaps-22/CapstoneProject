package com.diary.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.demo.model.ToDo;
import com.diary.demo.model.ToDoItems;
import com.diary.demo.repositories.ToDoItemsRepository;

@Service
public class ToDoItemService {
	
	@Autowired
	private  ToDoItemsRepository itemsRepository;

	public List<ToDoItems> getAllToDoItems() {
		 List<ToDoItems> toDoItemsList = new ArrayList<ToDoItems>();
		 itemsRepository.findAll().forEach(toDoItemsList::add);
		 return toDoItemsList;
}
	
	public List<String> getItemList(Long toDoId) {
		// TODO Auto-generated method stub
		List<String> itemsList= new ArrayList<String>();
		List<ToDoItems> allItemsList = new ArrayList<ToDoItems>();
		allItemsList = getAllToDoItems();
		for(ToDoItems item : allItemsList)
		{
			if(item.getToDo().getTodo_Id()== toDoId)
			{
				itemsList.add(item.getItem());
			}
		}
		itemsList.add("test");
		return itemsList;
		 
		
	}
}
