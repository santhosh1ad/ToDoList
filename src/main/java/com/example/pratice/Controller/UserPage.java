package com.example.pratice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pratice.Repository.User_Repo;
import com.example.pratice.Service.TaskService;
import com.example.pratice.Tables.*;

import jakarta.servlet.http.HttpSession;

import java.util.*;

@RestController
@RequestMapping("/")
@PreAuthorize("hasAuthority('ROLE_USER')")
public class UserPage {
	@Autowired
	public User_Repo repo;
	
	@Autowired
	public TaskService service;
	
	@Autowired
	public AdminPage service1;
	
	@Autowired
	private PasswordEncoder p;
	
	 @GetMapping("")
	    public String home() {

	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        String username = auth.getName();
	        System.out.println(username);
	        Optional<List<Remainder>> remainder = service1.getRemainder(username);
	        StringJoiner messageJoiner = new StringJoiner("<br>");

	        if (remainder.isPresent()) {
	            List<Remainder> messages = remainder.get();
	            for (Remainder message : messages) {
	                messageJoiner.add(message.toString()); // Assuming Remainder has a meaningful toString() method
	            }
	        } else {
	            messageJoiner.add("\n Set the Remainder and achieve the goal " + username);
	        }

	        SecurityContextHolder.clearContext();


	        return "Welcome to Home Page<br> " +username+" Task Pending "+ messageJoiner;
	 }
//<------------------------------------------------------------------------------------------------------------------------------->
	@GetMapping("/Add_user")
	public String Add_user(@RequestParam String name,@RequestParam String pass) {
		
		Details obj = new Details(name, p.encode(pass),"USER");
		repo.save(obj);
		
		
		return "You Have registered Successfully";
	}
	
//<---------------------------------------------------------------------------------------------------------------------------------->
	
	@GetMapping("/Create_Task")
	public String Create(@RequestParam String task, @RequestParam String category) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
		return service.setTasksForUser(username, task, category);
		
	}
	
//<----------------------------------------------------------------------------------------------------------------------------------->
	
	@GetMapping("/Edit_Task")
	public String Edit(@RequestParam int id, @RequestParam String task) {
		return service.editTask(id, task);
	}
	
//<------------------------------------------------------------------------------------------------------------------------------------->
	@GetMapping("/Delete_Task")
	public String Delete(@RequestParam int id) {
		return service.deleteTask(id);
		
	}
	
//<----------------------------------------------------------------------------------------------------------------------------------->
	@GetMapping("/History")
	public List<Task> histort(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return service.viewTaskHistory(username);
        
		
	}
//<----------------------------------------------------------------------------------------------------------------------------------->
	 @GetMapping("/messages")
	    public String messages() {

	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        String username = auth.getName();
	        System.out.println(username);
	        Optional<List<Message1>> remainder = service1.getMessages(username);
	        StringJoiner messageJoiner = new StringJoiner("<br>");

	        if (remainder.isPresent()) {
	            List<Message1> messages = remainder.get();
	            for (Message1 message : messages) {
	                messageJoiner.add(message.toString()); // Assuming Remainder has a meaningful toString() method
	            }
	        } else {
	            messageJoiner.add("\n Set the Remainder and achieve the goal " + username);
	        }

	        SecurityContextHolder.clearContext();


	        return "Messages are <br> " +username+" Task Pending "+ messageJoiner;
	 }
}
