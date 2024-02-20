package com.example.pratice.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pratice.Tables.*;

public interface Task_Repo extends JpaRepository<Task, Integer>{
	 //Task findById(int id);
	 void delete(Task task);
	 List<Task>findByUser(Details name);


}
