package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Logout implements IMessageAuswerten
{

	private IViewAktualisieren _view;	
	public Logout(IViewAktualisieren view)
	{
		this._view = view;
	}
		
	@Override
	public void auswerten(Message message) 
	{
		if(message.getContent().contains(StaticServerAnswerResources.Erfolgreich))
		{
			//_view.EntsprechendeMethode(true, message.getContent());
		}
		else if(message.getContent().contains(StaticServerAnswerResources.Fehlgeschlagen))
		{
			//_view.EntsprechendeMethode(false, message.getContent());
		}
	}

}
