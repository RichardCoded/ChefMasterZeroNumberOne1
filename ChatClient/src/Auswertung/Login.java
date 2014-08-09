package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Login implements IMessageAuswerten, IServerErrorAuswerten
{
	private IViewAktualisieren _view;
	public Login(IViewAktualisieren view)
	{
		this._view = view;		
	}
		
	@Override
	public void auswerten(Message message) 
	{	
		this._view.loginErgebnis(true, StaticServerAnswerResources.getChatOutputEvaluated(message).replaceFirst(this.getErrorType(), ""), message.getReceiver());
	}

	@Override
	public void errorAuswerten(Message message) 
	{
		_view.loginErgebnis(false,StaticServerAnswerResources.getChatOutputEvaluated(message).replaceFirst(this.getErrorType(), ""), message.getReceiver());		
	}

	@Override
	public String getErrorType() 
	{
		return "LOGIN:";
	}
}
