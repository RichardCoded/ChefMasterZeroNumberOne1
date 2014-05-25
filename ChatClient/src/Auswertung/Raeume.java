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
	public void Auswerten(Message message) 
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
			//Server ist schwul?
			//return;
		}
		
		// Der View die Liste ergebnis übergeben:
		// _view.aktualisiereBenutzer();
	}

	@Override
	public int getType() { return 2; }

}
