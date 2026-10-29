package com.project.chatd.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.chatd.Entity.User;

public interface UserRepository extends MongoRepository<User, String>{

}
