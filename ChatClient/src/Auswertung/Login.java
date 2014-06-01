package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Login implements IMessageAuswerten
{
	private IViewAktualisieren _view;
	public Login(IViewAktualisieren view)
	{
		this._view = view;		
	}
		
	@Override
	public void auswerten(Message message) 
	{
		if(message.getContent().contains(StaticServerAnswerResources.Erfolgreich))
		{
			System.out.println("Login erfolgreich");
			//this._view.entsprechendeMethode(true, StaticServerAnswerResources.getChatOutputEvaluated(message));
		}
		else if(message.getContent().contains(StaticServerAnswerResources.Fehlgeschlagen))
		{
			System.out.println("Login fehlgeschlagen");
			//this._view.entsprechendeMethode(false, StaticServerAnswerResources.getChatOutputEvaluated(message));
		}
		
	}
	
}
