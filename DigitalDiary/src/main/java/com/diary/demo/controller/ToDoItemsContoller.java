//package com.diary.demo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.diary.demo.model.ToDo;
//import com.diary.demo.model.ToDoItems;
//import com.diary.demo.repositories.ToDoItemsRepository;
//import com.diary.demo.service.ToDoItemService;
//
//
//@Controller
//public class ToDoItemsContoller {
//	@Autowired
//	private  ToDoItemService itemsService;
//	@GetMapping("/todoitems.html/{category}")
//	public String toDoItems(@PathVariable String category,Model model)
// {
//	
//		
//		List<ToDoItems> itemslist = itemsService.findByTodoname(category);
//		model.addAttribute("todoitems", itemslist);
//		
//		System.out.println("this is createtodo");
//		return "todoitems";
// }
//	
//	 
//}
