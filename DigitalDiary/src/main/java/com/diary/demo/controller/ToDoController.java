package com.diary.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diary.demo.model.ToDo;
import com.diary.demo.model.ToDoItems;
import com.diary.demo.service.ToDoItemService;
import com.diary.demo.service.UserToDoService;

import jakarta.validation.Valid;

@Controller
public class ToDoController {
	@Autowired
	private UserToDoService usertodoService;
	@Autowired
	private  ToDoItemService itemsService;
	
//	@RequestMapping("/")
//	String hello() {
//		System.out.println("this is hello");
//		return "testhtml";
//	}
	
	
//	  public List<ToDo> getAllTodo(Model model) {
//        return usertodoService.getAllToDo();
//    }
	 @GetMapping("/mainform")
	 public String mainpage(Model model,ToDo myToDo)
	 {
//			model.addAttribute("toDo", new ToDo());
//			ModelAndView mav = new ModelAndView("main");
		 List<ToDo> toDoInfo = usertodoService.getAllToDo();
			System.out.println(toDoInfo);
			model.addAttribute("toDoList", toDoInfo);
			System.out.println("this is main");
			return "main";
 }
	 
	@PostMapping(value = "/create")
	public String createToDo( ToDo toDo)
	{
		System.out.println(toDo.toString());
		usertodoService.createToDo(toDo);
		return "createtodo";
	}
	 @GetMapping("/addtodo")
	 public String toDopage(Model model)
	 {
			model.addAttribute("toDo", new ToDo());
//			ModelAndView mav = new ModelAndView("main");
//			mav.addObject("todo",usertodoService.getAllToDo());
//			
			System.out.println("this is createtodo");
			return "createtodo";
	 }
	 @GetMapping("/todoitems/{category}")
		public String toDoItems(@PathVariable String category,Model model)
	 {
		 System.out.println("this is listitems "+ category);
//		 List<ToDo> toDoInfo = new ArrayList<ToDo>();
		 Long toDoId = usertodoService.findByDescription(category);
		 List<String> itemsList = itemsService.getItemList(toDoId);
//			List<ToDoItems> itemslist = itemsService.findByTodoName(category);
			model.addAttribute("todoitems", itemsList);
			
			
			return "todoitemsview";
	 }
	
}
