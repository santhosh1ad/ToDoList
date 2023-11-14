package com.ToDoList.model;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/todo")
public class ToDoController {
   private final Repo obj1;
   
   public ToDoController(Repo obj1)
   {
	   this.obj1=obj1;
   }
   @GetMapping
   public List<ToList> getAllTodos() {
       return obj1.findAll();
   }
   @PostMapping
   public ToList createTodo(@RequestBody ToList todo) {
       return obj1.save(todo);
   }
   @PutMapping("/{id}")
   public ToList updateTodo(@PathVariable Long id, @RequestBody ToList updatedTodo) {
       ToList todo = obj1.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Invalid Todo id: " + id));

       todo.setTitle(updatedTodo.getTitle());
       todo.setCompleted(updatedTodo.isCompleted());

       return obj1.save(todo);
   }
   @DeleteMapping("/{id}")
   public void deleteTodo(@PathVariable Long id) {
       obj1.deleteById(id);
   }
  

}
@Controller
class Controllerclass {
    @RequestMapping("/")
    public String index() {
    	System.out.println("j");
    	return "index.jsp";
    }
}

