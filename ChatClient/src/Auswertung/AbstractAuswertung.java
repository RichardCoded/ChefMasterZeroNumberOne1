package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public abstract class AbstractAuswertung implements IMessageAuswerten
{	
	protected IViewAktualisieren _view;
	
	public AbstractAuswertung(IViewAktualisieren view)
	{
		this._view = view;
	}

	public abstract int getType();
	
}
