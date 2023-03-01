package com.diary.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diary.demo.model.ToDoItems;
@Repository
public interface ToDoItemsRepository  extends JpaRepository<ToDoItems,Long>{

}
