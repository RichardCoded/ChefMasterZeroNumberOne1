package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Leave implements IMessageAuswerten, IServerErrorAuswerten
{
	private IViewAktualisieren _view;
	public Leave(IViewAktualisieren view)
	{
		this._view = view;
	}
	
	@Override
	public void auswerten(Message message) 
	{
		_view.leaveErgebnis(true, StaticServerAnswerResources.getChatOutputEvaluated(message).replaceFirst(this.getErrorType(), ""));
	}

	@Override
	public void errorAuswerten(Message message) 
	{
		_view.leaveErgebnis(false, StaticServerAnswerResources.getChatOutputEvaluated(message).replaceFirst(this.getErrorType(), ""));
	}

	@Override
	public String getErrorType() 
	{
		return "LEAVE:";
	}
}
