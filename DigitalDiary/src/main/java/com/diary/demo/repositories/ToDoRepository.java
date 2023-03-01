package com.diary.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diary.demo.model.ToDo;
@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long>{
	ToDo findByDescription(String description);

}
