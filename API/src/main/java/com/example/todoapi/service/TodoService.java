package com.example.todoapi.service;

import com.example.todoapi.common.Enums;
import com.example.todoapi.model.entity.TodoEntity;
import com.example.todoapi.model.request.TodoRequest;
import com.example.todoapi.model.response.TodoResponse;
import com.example.todoapi.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public static final int RECORD_PER_PAGE = 10;

    public List<TodoResponse> searchTodo(String title, int page) {
        List<TodoEntity> entityList =
                todoRepository.findByTitleContainingIgnoreCase(title, PageRequest.of(page, RECORD_PER_PAGE));

        return entityList
                .stream()
                .map(entity -> mappingResponse(entity))
                .collect(Collectors.toList());
    }

    public TodoResponse getTodoDetail(Integer id) {
        Optional<TodoEntity> entity = todoRepository.findById(id);

        if (entity.isPresent()) {
            return mappingResponse(entity.get());
        }

        return new TodoResponse();
    }

    public void saveTodo(TodoRequest request) {
        // Prepare entity
        TodoEntity entity = modelMapper.map(request, TodoEntity.class);

        // Save db
        todoRepository.save(entity);
    }

    public void deleteTodo(Integer id) {
        todoRepository.deleteById(id);
    }

    public TodoResponse getTodo(Integer id) {
        Optional<TodoEntity> entityOp =
                todoRepository.findById(id);
        return entityOp
                .stream()
                .map(entity -> modelMapper.map(entity, TodoResponse.class))
                .collect(Collectors.toList()).get(0);
    }

    private TodoResponse mappingResponse(TodoEntity entity) {
        TodoResponse response = modelMapper.map(entity, TodoResponse.class);
        response.setStatus(Enums.TodoStatus.findByCode(entity.getStatus()).getValue());
        response.setCategory(Enums.TodoCategory.findByCode(entity.getCategory()).getValue());
        return response;
    }
}
