package com.diary.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.diary.demo.controller.ToDoController;
import com.diary.demo.security.config.SecurityConfiguration;
import com.diary.demo.service.UserService;
import com.diary.demo.service.UserServiceImpl;
import com.diary.demo.service.UserToDoService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {ToDoController.class,UserToDoService.class,SecurityConfiguration.class})
public class DigitalDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalDiaryApplication.class, args);
	}

}
