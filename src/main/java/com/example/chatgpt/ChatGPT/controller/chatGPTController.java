package com.example.chatgpt.ChatGPT.controller;


import com.example.chatgpt.ChatGPT.Pojo.BotRequest;
import com.example.chatgpt.ChatGPT.Pojo.ChatGPTResponse;
import com.example.chatgpt.ChatGPT.Service.BotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1")
public class chatGPTController {

    @Autowired
    private BotServiceImpl botService;

    @PostMapping ("/postDetails")
    public ChatGPTResponse ChatGPTDetails(@RequestBody BotRequest botrequest){
        //Logger if required

        return botService.askQuestion(botrequest);
    }
}
