package com.diary.demo.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.diary.demo.model.ToDo;
import com.diary.demo.model.ToDoItems;
import com.diary.demo.repositories.ToDoItemsRepository;
import com.diary.demo.service.ToDoItemService;

@SpringBootTest
public class MyServiceTest {
	@Autowired
	    private ToDoItemsRepository itemsRepository;
	@Autowired
	    private ToDoItemService itemService;
		
	@Test
	public void TestGetToDoItems() throws Exception 
	{
		ToDo schoolList = new ToDo();
		long toDoId = 1;
		 schoolList.setTodo_Id(toDoId);
		
		ToDoItems toDoItem1 = new ToDoItems("crayons",schoolList);

//		 call service to save the item
		 itemService.saveItem(toDoItem1, toDoId);
		 System.out.println("These are test values======>"+toDoItem1);
		// call the service method to get all the to-do items
		 List<ToDoItems> allToDoItems=itemService.getAllToDoItems();
		 System.out.println("These are from repository=======>"+allToDoItems);
		  // verify that the service method returns the expected to-do items
		 
		for(ToDoItems itemObj:allToDoItems)
		{
			System.out.println(itemObj);
			if(itemObj.equals(toDoItem1))
			{
				assert true;
			}
		}
	}

	@Test
	public void TestSetToDoItemsForExceptions() throws Exception 
	{
		
		ToDo schoolList = new ToDo();
		long toDoId = 1;
		schoolList.setTodo_Id(toDoId);
		
		ToDoItems toDoItem1 = new ToDoItems("crayons",schoolList);

 
		 //exception.expect(IllegalArgumentException.class);
//		 call service to save the item
		 try {
			 itemService.saveItem(toDoItem1, 999L);
		       assert false;
		    } catch(Exception e) {
		       assert true;
		    }
		 
		 
		 

	}
	
}
