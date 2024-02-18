package com.example.chatbot.service;

import com.example.chatbot.model.ChatMessage;
import com.example.chatbot.repository.ChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepo chatRepo;

    public String getChatHistory() {
        List<ChatMessage> messages = chatRepo.findAll();
        return "implement logic";
    }


    public ChatMessage saveMessage(ChatMessage chatMessage) {
        chatMessage.setTimestamp(java.time.LocalDateTime.now());
       return  chatRepo.save(chatMessage);
    }


}
