package Auswertung;

import java.util.ArrayList;

import Model.Message;
import View.IViewAktualisieren;

public class Benutzer extends AbstractAuswertung {

	
	public Benutzer(IViewAktualisieren view) 
	{
		super(view);		
	}

	@Override
	public void auswerten(Message message)
	{
		ArrayList<String> ergebnis = new ArrayList<String>();
		if(message.getContent().contains(";"))
		{
			String[] benutzer = message.getContent().split(";");
			for(String string : benutzer)
			{
				ergebnis.add(string);
			}
		}
		else if(!message.getContent().isEmpty())
		{
			ergebnis.add(message.getContent());
		}
		else if(message.getRoom().isEmpty())
		{
			//Server ist schwul?
			//return;
		}
		
		//Der View die Liste ergebnis übergeben, zum Beispiel: 
		this._view.BenutzerListeErhalten(ergebnis);
	}

	@Override
	public int getType() { return 1; }

		
}
