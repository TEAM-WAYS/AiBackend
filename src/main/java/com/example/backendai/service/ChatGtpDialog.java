package com.example.backendai.service;


import com.example.backendai.dto.ChatResponse;
import com.example.backendai.dto.Choice;
import com.example.backendai.dto.Message;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.example.backendai.dto.ChatRequest;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;


@Service
public class ChatGtpDialog {

    private WebClient webClient;


    public ChatGtpDialog(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1/chat/completions").build();
    }

    public List<Choice> chatWithGPT(String question) {
        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setModel("gpt-3.5-turbo");
        List<Message> lstMessages = new ArrayList<>(); //en liste af messages med roller
        lstMessages.add(new Message("system", "You are a helpful assistant."));
        lstMessages.add(new Message("user", "Where is Copenhagen"));
        chatRequest.setMessages(lstMessages);
        chatRequest.setN(1); //n er antal svar fra chatgpt
        chatRequest.setTemperature(1); //jo højere jo mere fantasifuldt svar (se powerpoint)
        chatRequest.setMaxTokens(30); //længde af svar
        chatRequest.setStream(false); //stream = true, er for viderekomne, der kommer flere svar asynkront
        chatRequest.setPresencePenalty(1);

        ChatResponse response = webClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .headers(h -> h.setBearerAuth("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"))
                .bodyValue(chatRequest)
                .retrieve()
                .bodyToMono(ChatResponse.class)
                .block();

        List<Choice> lst = response.getChoices();

        return lst;
    }











}
