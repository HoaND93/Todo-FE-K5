package com.example.todoapi.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SearchTodoRequest {
    @JsonProperty("title")
    private String title;

    @JsonProperty("page")
    private Integer page;
}
