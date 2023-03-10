package com.diary.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name ="Todo")
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Id")
	   private Long Id;
	@NotBlank(message = "Name may not be blank")
	@Column(name = "description")
	   private String description;
	@Column(name = "createdDate")
	   private Instant createdDate;
	@Column(name = "completed")
	   private boolean completed;
	@OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST,mappedBy ="toDo") 
		private List<ToDoItems> items;
	@ManyToOne
	 
	private User users;
		 
		public List<ToDoItems> getItems() 
		{
			return items;
		}
	
		public void setItems(List<ToDoItems> items) 
		{
			this.items = items;
		}
	
		public ToDo() 
		{
			   this.createdDate = Instant.now();
		 }
	
		public ToDo( String description, boolean status) 
		{
				       
			this.description = description;
			this.createdDate = Instant.now();
			this.completed = status;
		 }
		public Long getTodo_Id() 
		{
			return Id;
		}
	
		public void setTodo_Id(Long Id) 
		{
			this.Id = Id;
		}
	
		public String getDescription() 
		{
			return description;
		}
	
		public void setDescription(String description)
		{
			this.description = description;
		}
	
		public Instant getCreatedDate()
		{
			return createdDate;
		}
	
		public void setCreatedDate(Instant createdDate)
		{
			this.createdDate = createdDate;
		}
	
		public boolean isCompleted() {
			return completed;
		}
	
		public void setCompleted(boolean completed)
		{
			this.completed = completed;
		}
	
		public User getUsers() {
			// TODO Auto-generated method stub
			return users;
		}
//		public void setUsers( User currentUser) {
//			// TODO Auto-generated method stub
//			this.users =  User currentUser;
//		}
	
		   @Override 
		   public String toString()
		   {
			   return String.format("ToDo{todo_Id ='%d',description ='%s',createdDate ='%s'}",Id,description,createdDate);
		   }

		
	   
}
