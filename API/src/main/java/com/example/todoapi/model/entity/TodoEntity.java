package com.example.todoapi.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "todo")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="note")
    private String note;

    @Column(name="deadline")
    private String deadline;

    @Column(name="status")
    private Integer status;

    @Column(name="category")
    private Integer category;
}
