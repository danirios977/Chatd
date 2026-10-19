package com.project.chatd.Entity;

public class User {
	
	private int userId;
	private String phoneNumer;
	private String displayName;
	private String urlPhoto;
	private int chatId[];
	private int messageId[];
	private boolean isOnline;
	
	public User(int userId, String phoneNumer, String displayName, String urlPhoto, int[] chatId, int[] messageId) {

		this.userId = userId;
		this.phoneNumer = phoneNumer;
		this.displayName = displayName;
		this.urlPhoto = urlPhoto;
		this.chatId = chatId;
		this.messageId = messageId;
		this.isOnline = false;
	}

	//Getter and Setter
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPhoneNumer() {
		return phoneNumer;
	}

	public void setPhoneNumer(String phoneNumer) {
		this.phoneNumer = phoneNumer;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public int[] getChatId() {
		return chatId;
	}

	public void setChatId(int[] chatId) {
		this.chatId = chatId;
	}

	public int[] getMessageId() {
		return messageId;
	}

	public void setMessageId(int[] messageId) {
		this.messageId = messageId;
	}
	
	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
}
