package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Leave implements IMessageAuswerten
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
			_view.LeaveErgebnis(true);
		}
		else
		{
			_view.LeaveErgebnis(false);
		}
	}
}
