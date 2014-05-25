package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Servernachricht extends AbstractAuswertung {
	
	public Servernachricht(IViewAktualisieren view) 
	{
		super(view);		
	}

	@Override
	public void Auswerten(Message message) 
	{		
		
	}

	@Override
	public int getType() { return 8; }

}
