package com.example.pratice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.pratice.Tables.Message1;

@Repository
@EnableJpaRepositories
public interface MessRepo extends JpaRepository<Message1, Integer>{
	List<Message1>findMessagesByUsername(String username);

}
