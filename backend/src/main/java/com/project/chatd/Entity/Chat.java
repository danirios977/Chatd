package com.project.chatd.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chats")
public class Chat {
	
	@Id
	private String chatId;
	
	private String type; // "DIRECT" o "GROUP"
	private String name; // Se aplica cuando el chat es grupal
	private List<String> participantIds; // Id de los usuarios
	private Message lastMessage; // Guardar el resumen del último mensaje del chat
	private LocalDateTime createdAt;
	
	public Chat() {
	}

	public Chat(String chatId, String type, String name, List<String> participantIds, Message lastMessage,
			LocalDateTime createdAt) {

		this.chatId = chatId;
		this.type = type;
		this.name = ("GROUP".equalsIgnoreCase(type) ? name : null);
		this.participantIds = participantIds;
		this.lastMessage = lastMessage;
		this.createdAt = createdAt;
	}

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getParticipantIds() {
		return participantIds;
	}

	public void setParticipantIds(String participantIds) {
		this.participantIds = List.of(participantIds);
	}

	public Message getLastMessage() {
		return lastMessage;
	}

	public void setLastMessage(Message lastMessage) {
		this.lastMessage = lastMessage;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
