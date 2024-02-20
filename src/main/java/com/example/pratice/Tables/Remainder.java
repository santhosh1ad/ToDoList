package com.example.pratice.Tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Remainder {
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "username")
	    private String username;

	    @Column(name = "message")
	    private String message;

	    // Additional fields, constructors, getters, setters, etc. as needed
	    
	    public Remainder() {
	    }

	    // Constructor with fields
	    public Remainder(String username, String message) {
	        this.username = username;
	        this.message = message;
	    }

	    // Getters and setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

		@Override
		public String toString() {
			return "\n !!!!Remainder... [message=" + message + "]";
		}
	    
	}

