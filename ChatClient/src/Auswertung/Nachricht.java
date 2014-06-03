package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Nachricht extends AbstractAuswertung {

	
	public Nachricht(IViewAktualisieren view) 
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

}
