package com.project.chatd.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.chatd.Repository.UserRepository;
import com.project.chatd.Entity.User;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	private final UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> getAllUsers(){
		
		try {
			
			List<User> users = new ArrayList<>();
			users.addAll(userRepository.findAll());
			
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}catch(Exception e) {
			System.out.println("Error en optener todos los usuarios: "+e.getMessage());
			
			return null;
		}
	}
}
