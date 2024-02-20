package com.example.pratice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pratice.Tables.Details;
import com.example.pratice.Tables.Remainder;
import com.example.pratice.Tables.Task;
import com.example.pratice.Repository.User_Repo;
import com.example.pratice.Repository.RemainRepo;
import com.example.pratice.Repository.Task_Repo;

@Service
public class TaskService {
	@Autowired
	private RemainRepo rr;
	

    @Autowired
    private User_Repo userRepo;

    @Autowired
    private Task_Repo taskRepo;

    public String setTasksForUser(String username, String taskDescription, String category) {
        // Retrieve the user by username
    	try {
        Details user = userRepo.findByName(username)
                                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Create a new task and associate it with the user
        Task task = new Task(taskDescription, user, category);
        
        Remainder obj = new Remainder(username, taskDescription);
        rr.save(obj);

        // Save the task
        taskRepo.save(task);
        return "Successfully added";
    	}
    	catch(Exception e) {
             return "User Name Not Found";
    	}
    }
 //<-------------------------------------------------------------------------------------------------------------------------------->
    
    public String editTask(int taskId, String newTaskDescription) {
        // Retrieve the task by taskId
    	try {
        Task task = taskRepo.findById(taskId)
                            .orElseThrow(() -> new IllegalArgumentException("Task not found"));

        // Update the task description
        task.setTaskDescription(newTaskDescription);

        // Save the updated task
        taskRepo.save(task);
        return "Successfully Edited";
    }
    	catch(Exception e) {
    		return "Id not found please check it";
    	}
    }
    
 //<--------------------------------------------------------------------------------------------------------------------------------->
    
    public String deleteTask(int taskId) {
    	try {
        // Retrieve the task by taskId
        Task task = taskRepo.findById(taskId)
                            .orElseThrow(() -> new IllegalArgumentException("Task not found"));

        // Delete the task
        taskRepo.delete(task);
        return "deleted Successfully";
    	}
    	catch(Exception e) {
    		  return "Task Id not found please check it";
    		    
    	}
    }
    
 //<---------------------------------------------------------------------------------------------------------------------------------->
    
    public List<Task> viewTaskHistory(String username) {
        // Retrieve the user by username
        Details user = userRepo.findByName(username)
                                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Retrieve the task history for the user
        List<Task> taskHistory = taskRepo.findByUser(user);

        return taskHistory;
    }
    //<----------------------------------------------------------------------------------------------------------------------------------->
    
  
}
