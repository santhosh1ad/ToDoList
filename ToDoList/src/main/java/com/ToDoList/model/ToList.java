package com.ToDoList.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Lists")
public class ToList {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     private String title;
     private boolean completed;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
