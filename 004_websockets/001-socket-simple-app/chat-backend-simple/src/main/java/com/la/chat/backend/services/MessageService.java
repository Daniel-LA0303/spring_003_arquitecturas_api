package com.la.chat.backend.services;

import java.util.List;

import com.la.chat.backend.models.Message;

public interface MessageService {
	
    List<Message> findAll();
    
    void save(Message message);

}
