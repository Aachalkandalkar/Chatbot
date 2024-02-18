package com.example.chatbot.controller;

import com.example.chatbot.model.ChatMessage;
import com.example.chatbot.model.WhatsappRequest;
import com.example.chatbot.service.ChatService;
//import com.example.chatbot.service.WA;
import com.example.chatbot.service.WhatsappService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller
@RequestMapping("/")
@RestController
public class ChatController {


   @Autowired
    private ChatService chatService;

   @Autowired
   private WhatsappRequest whatsappRequest;

    @Autowired
    private WhatsappService whatsappService;

    @GetMapping
    public String home(Model model){
       String chatHistory  = chatService.getChatHistory();
       model.addAttribute("chatHistory" , chatHistory);
       return "chat";
    }

    @GetMapping("/send")
    public void sendMessage(){
        whatsappService.sendMessage();
    }


////    @PostMapping("/sendMessage")
//    public ChatMessage sendMessage(ChatMessage chatMessage){
//        return chatService.saveMessage(chatMessage);
////        return "/redirect";
//    }


//    @PostMapping
//    public void handleWhatsappMessage(@RequestBody WhatsappRequest requestBody) {
//        String message = requestBody.getBody();
//        String senderId = requestBody.getFrom();
//
//        System.out.println("Received message: " + message);
//        System.out.println("From: " + senderId);
//
//        // Call the function to send a message back to WhatsApp
////        WA.sendMessage("Hello from the other side.", senderId);
//    }

    @PostMapping("/receive")
    public void receiveMessage(@RequestBody HttpServletRequest whatsappRequest){
        String message = whatsappRequest.getPathInfo();
//        String senderId  = whatsappRequest.;

        System.out.println("Received message: " + message);
//        System.out.println("From: " + senderId);

    }
}
