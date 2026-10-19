package com.project.chatd.Entity;

public class Chat {
	
	private int chatId;
	private boolean isGroup;
	private User participants[];
	
	public Chat(int chatId, boolean isGroup, User[] participants) {
		super();
		this.chatId = chatId;
		this.isGroup = isGroup;
		this.participants = participants;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public boolean isGroup() {
		return isGroup;
	}

	public void setGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}

	public User[] getParticipants() {
		return participants;
	}

	public void setParticipants(User[] participants) {
		this.participants = participants;
	}
	
	
}
