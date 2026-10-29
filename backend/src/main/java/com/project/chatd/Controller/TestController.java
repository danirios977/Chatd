package com.project.chatd.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.chatd.Entity.Chat;
import com.project.chatd.Entity.Message;
import com.project.chatd.Entity.User;
import com.project.chatd.Repository.ChatRepository;
import com.project.chatd.Repository.MessageRepository;
import com.project.chatd.Repository.UserRepository;

@RestController
@RequestMapping("api/test")
public class TestController {
	
	@Autowired
	private UserRepository userRepository;
	private ChatRepository chatRepository;
	private MessageRepository messageRepository;
	
	@PostMapping("/users")
	public ResponseEntity<List<User>> createUsers(){
		
		try {
			
		User user1 = new User();
		User user2 = new User();
		
		user1.setUserId("1");
		user2.setUserId("2");
		
		user1.setUserName("Daniel");
		user2.setUserName("Daniela");
		
		user1.setEmail("daniel@example.com");
		user2.setEmail("daniela@example.com");
		
		user1.setPassword("1234");
		user2.setPassword("5678");
		
		user1.setAvatarUrl(null);
		user2.setAvatarUrl(null);
		
		user1.setStatus("OFFLINE");
		user2.setStatus("OFFLINE");
		
		user1.setLastSeen(LocalDateTime.now());
		user2.setLastSeen(LocalDateTime.now());
		
		user1.setCreatedAt(LocalDateTime.now());
		user2.setCreatedAt(LocalDateTime.now());
		
		this.userRepository.save(user1);
		this.userRepository.save(user2);
		
		// CHAT
		
		Chat chat1 = new Chat();
		
		chat1.setChatId("1");
		chat1.setType("DIRECT");
		chat1.setParticipantIds("1");
		chat1.setParticipantIds("2");
		
		// MESSAGE
		
		Message message1 = new Message();
		Message message2 = new Message();
		
		message1.setMessageId("1");
		message1.setChatId("1");
		message1.setContent("Hola Dani, soy un usuario de prueba");
		message1.setSenderId("1");
		message1.setMediaUrl(null);
		message1.setStatus("READ");
		message1.setCreatedAt(LocalDateTime.now());
		
		message2.setMessageId("2");
		message2.setChatId("1");
		message2.setContent("Hola Dani, yo tambien soy una usuaria de prueba");
		message2.setSenderId("2");
		message2.setMediaUrl(null);
		message2.setStatus("SENT");
		message2.setCreatedAt(LocalDateTime.now());
		
		this.messageRepository.save(message1);
		this.messageRepository.save(message2);
		
		chat1.setLastMessage(message2);
		chat1.setCreatedAt(LocalDateTime.now());
		
		this.chatRepository.save(chat1);
		
		this.userRepository.save(user1);
		this.userRepository.save(user2);
		
		List<User> savedUsers = new ArrayList<>();
		
		savedUsers.add(user1);
		savedUsers.add(user2);
		
		System.out.println("USUARIOS INSERTADOS CON EXITO");
		return new ResponseEntity<List<User>>(savedUsers, HttpStatus.CREATED);
		
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
			
			return null;
		}
		
	}
}
