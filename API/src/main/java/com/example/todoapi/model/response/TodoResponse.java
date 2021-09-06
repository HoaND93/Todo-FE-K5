package com.example.todoapi.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TodoResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("note")
    private String note;

    @JsonProperty("deadline")
    private String deadline;

    @JsonProperty("status")
    private String status;

    @JsonProperty("category")
    private String category;
}
