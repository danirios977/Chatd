package com.project.chatd.Entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
public class Message {
	
	@Id
	private String messageId;
	private String chatId;
	
	private String senderId; // Referencia al Usuario que envió el mensaje
	private String content;
	private String mediaUrl; // Para mensajes que tiene contenido multimedia
	private String status; // "SENT", "DELIVERED", "READ"
	private LocalDateTime createdAt;
	
	public Message() {
	}

	public Message(String messageId, String chatId, String senderId, String content, String mediaUrl, String status) {
		
		this.messageId = messageId;
		this.chatId = chatId;
		this.senderId = senderId;
		this.content = content;
		this.mediaUrl = mediaUrl;
		this.status = status;
		this.createdAt = LocalDateTime.now();
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
