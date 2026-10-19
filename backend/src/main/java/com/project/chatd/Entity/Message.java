package com.project.chatd.Entity;

public class Message {
	
	private int messageId;
	private String estado; //ENVIADO, ENTREGADO, NO ENTREGADO, LEÍDO, NO LEÍDO
	private String content;
	
	public Message(int messageId, String estado, String content) {
		this.messageId = messageId;
		this.estado = estado;
		this.content = content;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
