package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public abstract class AbstractAuswertung 
{	
	protected IViewAktualisieren _view;
	
	public AbstractAuswertung(IViewAktualisieren view)
	{
		this._view = view;
	}
	
	public abstract void Auswerten(Message message);
	public abstract int getType();
	
}
