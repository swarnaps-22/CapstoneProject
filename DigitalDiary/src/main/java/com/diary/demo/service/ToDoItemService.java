package com.diary.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.demo.model.ToDo;
import com.diary.demo.model.ToDoItems;
import com.diary.demo.repositories.ToDoItemsRepository;
import com.diary.demo.repositories.ToDoRepository;

@Service
public class ToDoItemService {
	@Autowired
	private ToDoRepository toDoRepository;
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
			if(item.getToDo()!=null && item.getToDo().getTodo_Id()== toDoId)
			{
				itemsList.add(item.getItem());
			}
		}
//		itemsList.add("test");
		return itemsList;
		 
		
	}
	 public void saveItem( ToDoItems toDoItems,Long toDoId) throws Exception
	 {
		
		System.out.println("todoId in SaveItem:"+toDoId);
		Optional<ToDo> toDoOption= toDoRepository.findById(toDoId);
		if(!toDoOption.isPresent()) throw new Exception("ToDo not found");
		ToDo toDo = toDoOption.get();
		toDoItems.setToDo(toDo);
		 itemsRepository.save(toDoItems);
	 }
	 
	 
}
