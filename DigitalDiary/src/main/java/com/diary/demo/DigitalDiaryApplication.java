package com.diary.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.diary.demo.controller.ToDoController;

@SpringBootApplication
@ComponentScan(basePackageClasses = ToDoController.class)
public class DigitalDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalDiaryApplication.class, args);
	}

}
