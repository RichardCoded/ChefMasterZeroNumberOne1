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
		this._view.chatMessageEmpfangen(StaticServerAnswerResources.getChatOutputEvaluated(message).replaceFirst(this.getErrorType(), ""));
	}

	@Override
	public int getType() { return Message.MESSAGE; }

	@Override
	public void errorAuswerten(Message message)
	{
		//Error auswerten, wenn es einen hier geben kann.
		System.out.println("Klasse Chatmessage: errorAuswerten()");
	}

	@Override
	public String getErrorType() 
	{
		return "MESSAGE:";
	}
	
	
}
