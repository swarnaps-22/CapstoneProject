package com.diary.demo.model;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name ="Todo")
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	   private Long Id;
	@Column(name = "description")
	   private String description;
	@Column(name = "createdDate")
	   private Instant createdDate;
	@Column(name = "completed")
	   private boolean completed;
	@OneToMany(mappedBy ="toDo") 
	private List<ToDoItems> items;
	 
	   public ToDo() {
		   this.createdDate = Instant.now();
	   }

	   public ToDo( String description, boolean status) {
	       
	       this.description = description;
	       this.createdDate = Instant.now();
	       this.completed = status;
	   }
	   public Long getTodo_Id() {
		return Id;
	}

	public void setTodo_Id(Long Id) {
		this.Id = Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	

	   @Override 
	   public String toString()
	   {
		   return String.format("ToDo{todo_Id ='%d',description ='%s',createdDate ='%s'}",Id,description,createdDate);
	   }
	   
}
