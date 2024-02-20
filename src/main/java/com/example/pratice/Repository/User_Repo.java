package com.example.pratice.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.pratice.Tables.*;

@Repository
public interface User_Repo extends JpaRepository<Details, Integer>{
	
	Optional<Details> findByName(String Name);
	 

}
