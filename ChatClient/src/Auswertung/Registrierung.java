package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Registrierung implements IMessageAuswerten
{
	private IViewAktualisieren _view;
	public Registrierung(IViewAktualisieren view)
	{
		this._view = view;
	}

	@Override
	public void Auswerten(Message message) 
	{
				
	}

}
