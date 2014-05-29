package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Login implements IMessageAuswerten
{
	private IViewAktualisieren _view;
	public Login(IViewAktualisieren view)
	{
		this._view = view;		
	}
		
	@Override
	public void Auswerten(Message message) 
	{
		
	}
	
}
