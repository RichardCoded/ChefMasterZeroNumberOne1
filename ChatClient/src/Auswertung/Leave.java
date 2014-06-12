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
		if(!message.getContent().contains("Error"))
		{
			_view.leaveErgebnis(true);
		}
		else
		{
			_view.leaveErgebnis(false);
		}
	}

	@Override
	public void errorAuswerten(Message message) 
	{
		
	}

	@Override
	public String getErrorType() 
	{
		return "LEAVE:";
	}
}
