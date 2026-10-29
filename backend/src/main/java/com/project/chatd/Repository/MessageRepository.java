package com.project.chatd.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.chatd.Entity.Message;

public interface MessageRepository extends MongoRepository<Message, String>{

}
