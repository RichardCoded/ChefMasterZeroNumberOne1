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
		this._view.ChatMessageEmpfangen(message.getContent());
	}

	@Override
	public int getType() { return 0; }

}
