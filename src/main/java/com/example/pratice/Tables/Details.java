package com.example.pratice.Tables;

import jakarta.persistence.*;
import java.util.Set; // Import Set for the new data type of Role

@Entity
public class Details {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "Pass")
    private String Pass;
    
   private String role;

    // Getters and setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }
    
    public String getRole()
    {
    	return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }


    // Constructors
    public Details() {
    }

    public Details(String name, String pass, String roles) {
        super();
        this.name = name;
        Pass = pass;
        this.role = roles;
    }   
}
