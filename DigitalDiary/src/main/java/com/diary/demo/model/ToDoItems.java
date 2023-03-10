package com.diary.demo.model;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name ="ToDoItems")
public class ToDoItems {
	   @Id
	   @GeneratedValue(strategy = GenerationType.SEQUENCE)
	   @Column
	   private Long item_Id;
	   @NotBlank(message = "Name may not be blank")
	   private String item;
		@ManyToOne
		@JoinColumn(name = "todoId")
	   private ToDo toDo;
		
		public ToDoItems(String item, ToDo toDo)
		{
			this.item = item;
			this.toDo = toDo;
		}
		public ToDoItems()
		{
			
		}
//		public ToDoItems(String itemName,Long itemId)
//		{
//			this.item =itemName;
//			this.item_Id = itemId;
//		}
		public Long getItem_Id() {
			return item_Id;
		}
		public void setItem_Id(Long item_Id) {
			this.item_Id = item_Id;
		}
		public String getItem() {
			return item;
		}
		public void setItem(String inputItem) {
			this.item = inputItem;
		}
		public ToDo getToDo()
		{
			return toDo;
		}
		public void setToDo(ToDo td)
		{
			this.toDo = td ;
		}
		
		@Override
		public String toString() {
			return "ToDoItems [item_Id=" + item_Id + ", item=" + item + "]";
		}
}
