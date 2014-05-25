package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Nachricht extends AbstractAuswertung {

	
	public Nachricht(IViewAktualisieren view) 
	{
		super(view);		
	}

	@Override
	public void Auswerten(Message message) 
	{
		String ergebnis;
		
		if(!message.getReceiver().isEmpty())
		{
			ergebnis = "["+message.getSender() + " > " + message.getReceiver()+" : "+message.getContent();
		}
		else if(!message.getRoom().isEmpty())
		{
			ergebnis = message.getSender() + ": " + message.getContent();
		}
		else if(message.getRoom().isEmpty() && message.getReceiver().isEmpty())
		{
			//Wenn beide leer, dann Nachricht verwerfen:
			return;
			//throw new IllegalArgumentException("Server ist schwul, weil Raum und Empfänger leer sind.");
		}
		
		
		//Die Gui-Methode zum Aktualisieren der GUI in Bezug auf diese Nachricht aufrufen
		//z.B.:
		//window.NewMessageArrived(String ergebnis);
	}

	@Override
	public int getType() { return 0; }

}
