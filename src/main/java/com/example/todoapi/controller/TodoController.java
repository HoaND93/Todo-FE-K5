package com.example.todoapi.controller;

import com.example.todoapi.model.request.SearchTodoRequest;
import com.example.todoapi.model.request.TodoRequest;
import com.example.todoapi.model.response.TodoResponse;
import com.example.todoapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    private TodoService todoService;


    @PostMapping("/search")
    public List<TodoResponse> searchTodo(@RequestBody SearchTodoRequest searchTodoRequest) {
        return todoService.searchTodo(searchTodoRequest.getTitle(), searchTodoRequest.getPage());
    }

    @PostMapping("")
    public ResponseEntity<String> addTodo(@RequestBody TodoRequest todoRequest) {
        todoService.saveTodo(todoRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<String> updateTodo(@RequestBody TodoRequest todoRequest) {
        todoService.saveTodo(todoRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TodoResponse getTodo(@PathVariable(value = "id") Integer id) {
        return todoService.getTodo(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable(value = "id") Integer id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
