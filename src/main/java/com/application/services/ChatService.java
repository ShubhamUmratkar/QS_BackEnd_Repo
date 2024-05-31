package com.application.services;
import com.application.model.Message;
import com.application.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {
    @Autowired
    private MessageRepository messageRepository;

    public void saveMessage(Message message) {
        Message messageentity = new Message();

        messageentity.setMessage(message.getMessage());
        messageentity.setSender(message.getSender());
        messageentity.setTimestamp(LocalDateTime.now());
        messageRepository.save(messageentity);
    }

    public List<Message> getAllMessages(String email) {
        return messageRepository.findByEmailOrderByTimestampDesc(email);
    }
}