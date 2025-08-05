package com.la.chat.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.la.chat.backend.models.Message;
import com.la.chat.backend.repository.MessageRepository;

@Service
public class MessageServiceMongo implements MessageService{
    
	private final MessageRepository repository;

    public MessageServiceMongo(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Message> findAll() {
        return repository.findFirst10ByOrderByDateAsc();
    }

    @Override
    public void save(Message message) {
        repository.save(message);
    }
}
