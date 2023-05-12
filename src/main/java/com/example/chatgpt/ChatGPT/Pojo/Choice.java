package com.example.chatgpt.ChatGPT.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choice {

    private String text;
    private Integer index;
    @JsonProperty("finish_reason")
    private String finishReason;
}
