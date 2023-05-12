package com.example.chatgpt.ChatGPT.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ChatGPTResponse {

    private String id;
    private String object;
    private LocalDate created;
    private String model;
    private List<Choice> chioces;
}
