package com.example.todoapi.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
public class TodoRequest {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("note")
    private String note;

    @JsonProperty("deadline")
    private String deadline;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("category")
    private Integer category;
}
