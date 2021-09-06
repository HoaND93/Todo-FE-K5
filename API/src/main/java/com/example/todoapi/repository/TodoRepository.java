package com.example.todoapi.repository;

import com.example.todoapi.model.entity.TodoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends PagingAndSortingRepository<TodoEntity, Integer> {

    List<TodoEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
