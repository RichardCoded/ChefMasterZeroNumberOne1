package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Register implements IMessageAuswerten, IServerErrorAuswerten
{
	private IViewAktualisieren _view;
	public Register(IViewAktualisieren view)
	{
		this._view = view;
	}

	@Override
	public void auswerten(Message message) 
	{
		_view.registrierungErgebnis(StaticServerAnswerResources.getChatOutputEvaluated(message).replaceFirst(this.getErrorType(), ""));
	}

	@Override
	public void errorAuswerten(Message message) 
	{
		_view.registrierungErgebnis(StaticServerAnswerResources.getChatOutputEvaluated(message).replaceFirst(this.getErrorType(), ""));		
	}

	@Override
	public String getErrorType() 
	{
		return "REGISTER:";
	}
	
	
}
