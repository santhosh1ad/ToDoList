package com.ToDoList.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Repo extends JpaRepository<ToList, Long> {
    // Additional custom query methods can be defined here if needed
}