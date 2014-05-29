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
	public void Auswerten(Message message) 
	{
		
	}

}
