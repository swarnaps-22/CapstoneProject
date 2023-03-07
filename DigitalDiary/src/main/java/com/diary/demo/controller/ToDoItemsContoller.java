//package com.diary.demo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.diary.demo.model.ToDo;
//import com.diary.demo.model.ToDoItems;
//import com.diary.demo.repositories.ToDoItemsRepository;
//import com.diary.demo.service.ToDoItemService;
//import com.diary.demo.service.UserToDoService;
//
//
//@Controller
//public class ToDoItemsContoller {
//	@Autowired
//	private  ToDoItemService itemsService;
//	@Autowired
//	private UserToDoService usertodoService;
//	 @GetMapping("/{category}")
//		public String toDoItems(@PathVariable String category,Model model,ToDoItems itemsInToDo)
//		 {
//			 System.out.println("this is listitems "+ category);
//////			 List<ToDo> toDoInfo = new ArrayList<ToDo>();
//			
//			 Long toDoId = usertodoService.findByDescription(category);
//			 System.out.println("this is listitems Id "+ toDoId);
//			 List<String> itemsList = itemsService.getItemList(toDoId);
//			 System.out.println("this is itemsList "+ itemsList);
////				List<ToDoItems> itemslist = itemsService.findByTodoName(category);
//				model.addAttribute("todoitems", itemsList);
////				
////				
//				return "todoitemsview";
//		 }
//		 @PostMapping(value ="/additems")
//			public String createToDo( ToDoItems toDoItemList)
//			{
//			 
//				System.out.println(toDoItemList.toString());
//				itemsService.saveItems(toDoItemList);
//				return "todoitemsview";
//			}
//	 
//}
