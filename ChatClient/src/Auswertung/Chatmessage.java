package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Chatmessage extends AbstractAuswertung implements IServerErrorAuswerten
{

	
	public Chatmessage(IViewAktualisieren view) 
	{
		super(view);		
	}

	@Override
	public void auswerten(Message message) 
	{
		//this._view.entsprechendeMethode(StaticServerAnswerResources.getChatOutputEvaluated(message));		
		this._view.chatMessageEmpfangen(StaticServerAnswerResources.getChatOutputEvaluated(message));
	}

	@Override
	public int getType() { return Message.MESSAGE; }

	@Override
	public void errorAuswerten(Message message)
	{
		System.out.println("Message: Error auswerten blablub");
		
	}

	@Override
	public String getErrorType() 
	{
		return "MESSAGE:";
	}
	
	
}
