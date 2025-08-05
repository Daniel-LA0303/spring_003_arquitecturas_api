package com.la.chat.backend.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.la.chat.backend.models.Message;
import com.la.chat.backend.services.MessageService;

@Service
public class MessageServiceImpl implements MessageService{
	
    private final List<Message> messages = new ArrayList<>();

    @Override
    public List<Message> findAll() {
        return messages;
    }

    @Override
    public void save(Message message) {
        messages.add(message);
    }


}
