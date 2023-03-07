package com.diary.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.diary.demo.model.ToDoItems;
@Repository
public interface ToDoItemsRepository  extends JpaRepository<ToDoItems,Long>{

	void save(Long toDoId);
//	@Query("SELECT item FROM to_do_items todoitems WHERE todoitems.item IS NULL")
//    boolean findEmptyItemColumn();

}
