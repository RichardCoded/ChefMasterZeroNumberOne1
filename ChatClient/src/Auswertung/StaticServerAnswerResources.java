package Auswertung;

import javax.swing.JOptionPane;

import Model.Message;

public class StaticServerAnswerResources 
{
	public static final String Erfolgreich = "erfolgreich";
	public static final String Fehlgeschlagen = "fehlgeschlagen";
	public static final String Error = "Error";
	
	public static String getChatOutputEvaluated(Message message)
	{
		return getSenderReceiverEvaluated(message) + " : " + message.getContent();
	}
	
	private static String getSenderReceiverEvaluated(Message message)
	{
		return "[" + getSender(message) + " -> " + getReceiver(message) + "]";
	}
	
	private static String getSender(Message message)
	{
		if(message.getSender() != null)
		{
			return message.getSender();
		}
		else
		{
			return "Server";
		}
	}
	
	private static String getReceiver(Message message)
	{
		if(message.getReceiver() != null)
		{
			return "Me";
		}
		else if(message.getRoom() != null)
		{
			return message.getRoom();
		}
		
		return "server sucks";
		
	}		
}
