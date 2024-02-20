package com.example.pratice.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pratice.Repository.MessRepo;
import com.example.pratice.Repository.RemainRepo;
import com.example.pratice.Tables.*;


@Service
public class AdminPage{
	
	@Autowired
	public RemainRepo repo;
	
	
	@Autowired
	public MessRepo repo2;

	public Optional<List<Remainder>> getRemainder(String username) {
	    List<Remainder> messages = repo.findMessagesByUsername(username);
	    
	    // Check if messages are found for the given username
	    if (messages != null && !messages.isEmpty()) {
	        return Optional.of(messages);
	    } else {
	        return Optional.empty();
	    }
	}
	
	
	public Optional<List<Message1>> getMessages(String username) {
	    List<Message1> messages = repo2.findMessagesByUsername(username);
	    
	    // Check if messages are found for the given username
	    if (messages != null && !messages.isEmpty()) {
	        return Optional.of(messages);
	    } else {
	        return Optional.empty();
	    }
	}

}