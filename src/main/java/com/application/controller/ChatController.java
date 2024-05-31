package com.application.controller;

import com.application.model.Message;
import com.application.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;


    @PostMapping("/send-message")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> sendMessage(@RequestBody Message message, String email) {
        chatService.saveMessage(message);
        System.out.println("Send Message Hit");
        System.out.println(email);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-messages/{email}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Message>> getMessages(@PathVariable String email) {
        List<Message> messages = chatService.getAllMessages(email);
        return ResponseEntity.ok(messages);
    }
}