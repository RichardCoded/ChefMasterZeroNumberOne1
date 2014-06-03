package Model;

import java.io.Serializable;
public class Message implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
	public static final int MESSAGE 	= 0; // Message in the chat
	public static final int LOGIN 		= 1; // Login this client,send him the users- and rooms list and send him to "mainlobby"
	public static final int LOGOUT 		= 2; // Logout this client, remove him from userlist and send the user the new room
	public static final int REGISTER 	= 3; // Register this client in the database (only register, dont log him in yet)
	public static final int JOIN 		= 4; // Join a user to an existing room or create one if it not exists 
	public static final int LEAVE 		= 5; // Leave a user from an existing room and destroy the room if it is empty
	public static final int USERS 		= 6; // Show a list of users from the current room
	public static final int ROOMS 		= 7; // Show a list of rooms
	public static final int SERVERSUCCESS	= 8; // Show a servermessage
	public static final int SERVERERROR	= 9; // Show a errormessage    

    private int type;
    private String sender;
    private String content;
    private String receiver;
    private String room;
    
    public Message(){
        
    }
    
    public Message(int type, String sender, String content, String receiver, String room) 
    {
        this.type = type;
        this.sender = sender;
        this.content = content;
        this.receiver = receiver;
        this.room = room;
    }
    
    
    @Override
    public String toString() {
    	return "{type='"+type+"', sender='"+sender+"', content='"+content+"', receiver='"+receiver+"', room='"+room+"'}";
    }
        
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
}