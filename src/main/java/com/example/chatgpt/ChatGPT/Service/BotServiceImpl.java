package com.example.chatgpt.ChatGPT.Service;

import com.example.chatgpt.ChatGPT.Pojo.BotRequest;
import com.example.chatgpt.ChatGPT.Pojo.ChatGPTResponse;
import com.example.chatgpt.ChatGPT.Pojo.ChatGptRequest;
import com.example.chatgpt.ChatGPT.config.ChatGPTConfig;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BotServiceImpl {

    private static RestTemplate restTemplate = new RestTemplate();

    //    Build headers
    public HttpEntity<ChatGptRequest> buildHttpEntity(ChatGptRequest chatRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(ChatGPTConfig.MEDIA_TYPE));
        headers.add(ChatGPTConfig.AUTHORISATION, ChatGPTConfig.BEARER + ChatGPTConfig.API_KEY);
        return new HttpEntity<>(chatRequest, headers);
    }

    //    Generate response
    public ChatGPTResponse getResponse(HttpEntity<ChatGptRequest> chatRequestHttpEntity) {
        ResponseEntity<ChatGPTResponse> responseEntity = restTemplate.postForEntity(
                ChatGPTConfig.URL,
                chatRequestHttpEntity,
                ChatGPTResponse.class);

        return responseEntity.getBody();
    }

    public ChatGPTResponse askQuestion(BotRequest botRequest) {
        return this.getResponse(
                this.buildHttpEntity(
                        new ChatGptRequest(
                                ChatGPTConfig.MODEL,
                                botRequest.getMessage(),
                                ChatGPTConfig.MAX_TOKN,
                                ChatGPTConfig.TEMPARATURE,
                                ChatGPTConfig.TOP_P)));
    }
}
