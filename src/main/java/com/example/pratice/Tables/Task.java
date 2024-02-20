package com.example.pratice.Tables;



import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "task_description")
    private String taskDescription;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Details user;
    
    @Column(name = "category")
    private String category; // New field to represent the category
    
    


    public Task() {
    }

    public Task(String taskDescription, Details user, String category) {
        this.taskDescription = taskDescription;
        this.user = user;
        this.category=category;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Details getUser() {
        return user;
    }

    public void setUser(Details user) {
        this.user = user;
    }
    public Task(String m) {
    	
    }
}
