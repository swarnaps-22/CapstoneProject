package com.diary.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.diary.demo.model.ToDo;
import com.diary.demo.model.ToDoItems;
import com.diary.demo.service.ToDoItemService;
import com.diary.demo.service.UserToDoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("sessionTodoId")
public class ToDoController {
	@Autowired
	private UserToDoService usertodoService;
	@Autowired
	private  ToDoItemService itemsService;
	
    @ModelAttribute("sessionTodoId")
    public Long sessionTodoId() {return 0L;}
	
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
	 
//	@GetMapping(value ="/createTodo1")
//	public String createMainToDo( Model model,ToDo toDo)
//	{
//		System.out.println("Invoked createTodo");
//		
//		model.addAttribute("toDo", new ToDo());
//		return "createtodo";
//	}
	 
	@PostMapping(value ="/create")
	public String createToDo( Model model, ToDo toDo)
	{
		System.out.println("Invoked createTodo");
		System.out.println(toDo.toString());
		usertodoService.createToDo(toDo);
		List<ToDo> toDoInfo = usertodoService.getAllToDo();
		System.out.println(toDoInfo);
		model.addAttribute("toDoList", toDoInfo);
		System.out.println("this is main");
		return "main";
	}
	@GetMapping("/addtodo")
	public String toDopage(Model model)
	{
		model.addAttribute("toDo", new ToDo());
		System.out.println("Creating toDo List");
		return "createtodo";
	}

	@GetMapping("/item/{category}")

	public String toDoItems(@PathVariable String category,Model model)
	 {
		
		 model.addAttribute("toDoItem", new ToDoItems());
		 System.out.println("this is todo category "+ category);
//		 List<ToDo> toDoInfo = new ArrayList<ToDo>();
	
		 Long toDoId = usertodoService.findIdByDescription(category);
		 System.out.println("this is todo Id "+ toDoId);
		
		 List<String> itemsList = itemsService.getItemList(toDoId);
		 model.addAttribute("sessionTodoId", toDoId);

		 System.out.println("this is itemsList "+ itemsList);
//			List<ToDoItems> itemslist = itemsService.findByTodoName(category);
		model.addAttribute("todoitems", itemsList);
			
		return "todoitemsview";
	 }
	@PostMapping(value ="/additems")
	public String createToDoItem(Model model,ToDoItems toDoItem)
	{
		Long toDoId = (Long) model.getAttribute("sessionTodoId");
		System.out.println("toDoId "+ toDoId);
		System.out.println("CreateToDo "+ toDoItem.toString());
		try
		{
			itemsService.saveItem(toDoItem,toDoId);
		}
		catch(Exception e)
		{
			System.out.println("exception caught");
		}
		
		model.addAttribute("toDoItem", new ToDoItems());
		List<String> itemsList = itemsService.getItemList(toDoId);
		
		model.addAttribute("todoitems", itemsList);
		return "todoitemsview";
	}
	@GetMapping("/deleteItem/{item}")
	public String deleteToDoItem(@PathVariable String item,Model model)
	{
		System.out.println("delete item is "+ item);
		
		itemsService.deleteItem(item);
		
		model.addAttribute("toDoItem", new ToDoItems());
		
		Long toDoId = (Long) model.getAttribute("sessionTodoId");
		System.out.println("toDoId "+ toDoId);
		List<String> itemsList = itemsService.getItemList(toDoId);
		
		model.addAttribute("todoitems", itemsList);
		return "todoitemsview";
	}
//	Updating Itemslist
	@PostMapping("/updateItem/{ItemNameToUpdate}")
		public String updateItem(@PathVariable String ItemNameToUpdate,Model model, ToDoItems toDoItem, BindingResult bindingResult)
		{
		
		System.out.println("Item name to update=====>   "+ItemNameToUpdate);
			
			System.out.println(toDoItem);
			Long toDoId = (Long) model.getAttribute("sessionTodoId");
			try
			{
				itemsService.updateItem(ItemNameToUpdate,toDoItem,toDoId);
			}
			catch(Exception e)
			{
				System.out.println("Exception in update");
			}
			
			model.addAttribute("toDoItem", new ToDoItems());
			
			
			
			System.out.println("toDoId "+ toDoId);
			List<String> itemsList = itemsService.getItemList(toDoId);
			
			model.addAttribute("todoitems", itemsList);
			return "todoitemsview";
		}
	
}
