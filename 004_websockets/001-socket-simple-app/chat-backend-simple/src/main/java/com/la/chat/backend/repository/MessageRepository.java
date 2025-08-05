package com.la.chat.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.la.chat.backend.models.Message;

public interface MessageRepository extends MongoRepository<Message, String> {
    
	List<Message> findFirst10ByOrderByDateAsc();
	
}
