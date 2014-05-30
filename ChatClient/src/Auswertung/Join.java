package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Join implements IMessageAuswerten
{
	private IViewAktualisieren _view;
	public Join(IViewAktualisieren view)
	{
		this._view = view;
	}

	@Override
	public void auswerten(Message message) 
	{
		
	}

}
