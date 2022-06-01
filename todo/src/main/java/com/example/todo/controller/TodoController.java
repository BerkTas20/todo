package com.example.todo.controller;

import com.example.todo.entity.Todo;
import com.example.todo.services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private TodoService todoService;

    @PostMapping("/addTodo")
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.saveTodo(todo);
    }

    @GetMapping("/todos")
    public List<Todo> findAllTodos(){
        return todoService.getTodos();
    }

    @GetMapping("/todo/{id}")
    public Todo findTodoById(@PathVariable int id){
        return todoService.getTodoById(id);
    }

    @PutMapping("/update")
    public Todo updateTodo(@RequestBody Todo todo){
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@RequestBody int id){
        return todoService.deleteTodo(id);
    }
}
