package com.scm.helper;

import lombok.Builder;

@Builder
public class Message {
	
	public String content;

	private MessageType type=MessageType.green;
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	public Message(String content, MessageType type) {
		super();
		this.content = content;
		this.type = type;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

}
