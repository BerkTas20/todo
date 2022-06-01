package com.example.todo.services;


import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository repository;

    public Todo saveTodo(Todo todo){
        return repository.save(todo);
    }

    public List<Todo> saveTodos(List<Todo> todos){
        return repository.saveAll(todos);
    }

    public List<Todo> getTodos(){
        return repository.findAll();
    }

    public Todo getTodoById(int id){
        return repository.findById(id).orElse(null);
    }


    public Todo updateTodo(Todo todo){
        Todo existingTodo = repository.findById(todo.getId()).orElse(null);
        existingTodo.setTask(todo.getTask());
        existingTodo.setCreateTime(todo.getCreateTime());
        existingTodo.setStatus(todo.getStatus());
        existingTodo.setUpdateTime(todo.getUpdateTime());
        return repository.save(existingTodo);

    }

    public String deleteTodo(int id){
        repository.deleteById(id);
        return "Todo silindi" + id;
    }
}
