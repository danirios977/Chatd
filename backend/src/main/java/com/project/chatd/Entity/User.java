package com.project.chatd.Entity;


import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	
	@Id
	private String userId;
	
	private String userName;
	private String email;
	private String password;
	private String avatarUrl; //Foto de perfil
	private String status; // "ONLINE", "OFFLINE"
	private LocalDateTime lastSeen; // Ultima vez conectado
	private LocalDateTime createdAt; //Fecha de registro
	
	public User() {
	}
	
	public User(String userId, String userName, String email, String password, String avatarUrl) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.avatarUrl = avatarUrl;
		this.createdAt = LocalDateTime.now();
		this.lastSeen = LocalDateTime.now();
		this.status = "OFFLINE";
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(LocalDateTime lastSeen) {
		this.lastSeen = lastSeen;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
