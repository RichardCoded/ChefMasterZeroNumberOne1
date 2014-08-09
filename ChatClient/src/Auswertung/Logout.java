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
		this._view.logoutErgebnis(true, StaticServerAnswerResources.getChatOutputEvaluated(message).replaceFirst(this.getErrorType(), ""));
	}

	@Override
	public void errorAuswerten(Message message) 
	{
		this._view.logoutErgebnis(true, StaticServerAnswerResources.getChatOutputEvaluated(message).replaceFirst(this.getErrorType(), ""));
	}

	@Override
	public String getErrorType() 
	{
		return "LOGOUT:";
	}
}
