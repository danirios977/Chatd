package com.project.chatd.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.chatd.Entity.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	Optional<User> findById(String id);
	List<User> findByEmail(String email);
	List<User> findByUserName(String userName);
	List<User> findByUserNameContainingIgnoreCase(String userName);
	
}
