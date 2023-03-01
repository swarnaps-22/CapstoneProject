package com.diary.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diary.demo.model.ToDo;
import com.diary.demo.service.UserToDoService;

import jakarta.validation.Valid;

@Controller
public class ToDoController {
	@Autowired
	private UserToDoService usertodoService;
	
//	@RequestMapping("/")
//	String hello() {
//		System.out.println("this is hello");
//		return "testhtml";
//	}
	
	@GetMapping("/mainform")
//	  public List<ToDo> getAllTodo(Model model) {
//        return usertodoService.getAllToDo();
//    }
 public String mainpage(Model model)
 {
		model.addAttribute("toDo", new ToDo());
		System.out.println("this is main");
		return "main";
 }
	@PostMapping(value = "/create")
	//@PostMapping(value = "/", consumes = {"application/xml","application/json"}) 
	public String createToDo( ToDo toDo)
	{
		System.out.println(toDo.toString());
		usertodoService.createToDo(toDo);
		return "main";
	}

}
