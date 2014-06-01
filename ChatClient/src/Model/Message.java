package Model;

import java.io.Serializable;
public class Message implements Serializable{
    
    private static final long serialVersionUID = 1L;

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