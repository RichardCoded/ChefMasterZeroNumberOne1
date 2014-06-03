package Auswertung;

import java.util.ArrayList;

import Model.Message;
import View.IViewAktualisieren;

public class Raeume extends AbstractAuswertung {

	public Raeume(IViewAktualisieren view) 
	{
		super(view);		
	}

	@Override
	public void auswerten(Message message) 
	{
		ArrayList<String> ergebnis = new ArrayList<String>();
		if(message.getContent().contains(";"))
		{
			String[] raeume = message.getContent().split(";");
			for(String string : raeume)
			{
				ergebnis.add(string);
			}
		}
		else if(!message.getContent().isEmpty())
		{
			ergebnis.add(message.getContent());
		}
		else if(message.getReceiver().isEmpty())
		{
			//der Receiver wird eigentlich nicht benötigt.
			//return;
		}
		
		// Der View die Liste ergebnis übergeben:
		this._view.raeumeListeErhalten(ergebnis);
	}

	@Override
	public int getType() { return Message.ROOMS; }

}
