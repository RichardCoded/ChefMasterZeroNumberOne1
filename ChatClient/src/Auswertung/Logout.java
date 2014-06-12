package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Logout implements IMessageAuswerten, IServerErrorAuswerten
{

	private IViewAktualisieren _view;	
	public Logout(IViewAktualisieren view)
	{
		this._view = view;
	}
		
	@Override
	public void auswerten(Message message) 
	{
		if(message.getContent().contains("erfolgreich"))
		{
			this._view.logoutErgebnis(true, "hat sich erfolgreich ausgeloggt");
		}
		else if(message.getContent().contains(StaticServerAnswerResources.Fehlgeschlagen))
		{
			//_view.EntsprechendeMethode(false, message.getContent());
		}
	}

	@Override
	public void errorAuswerten(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getErrorType() 
	{
		return "LOGOUT:";
	}
}
