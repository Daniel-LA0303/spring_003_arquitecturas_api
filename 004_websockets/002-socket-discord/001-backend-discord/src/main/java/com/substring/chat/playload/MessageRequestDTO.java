package com.substring.chat.playload;

public class MessageRequestDTO {

    private String content;
    private String sender;
    private String roomId;
	
    public MessageRequestDTO() {
	
	}
	
	public MessageRequestDTO(String content, String sender, String roomId) {
		this.content = content;
		this.sender = sender;
		this.roomId = roomId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

}
