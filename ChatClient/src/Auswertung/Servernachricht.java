package Auswertung;

import java.util.ArrayList;

import Model.Message;
import View.IViewAktualisieren;

public class Servernachricht extends AbstractAuswertung {
	
	private ArrayList<IMessageAuswerten> _servermessages = new ArrayList<IMessageAuswerten>();
	private void setServerMessage()
	{
		this._servermessages = new ArrayList<IMessageAuswerten>()
		{
			{
				add(new Registrierung(_view));
				add(new Login(_view));
				add(new Logout(_view));
				add(new Join(_view));
				add(new Leave(_view));				
			}
		};
	}
	
	public Servernachricht(IViewAktualisieren view) 
	{
		super(view);
		setServerMessage();
	}

	@Override
	public void auswerten(Message message) 
	{		
		for(IMessageAuswerten auswertungsklasse : this._servermessages)
		{
			if(message.getContent().contains(auswertungsklasse.getClass().getSimpleName()))
			{
				auswertungsklasse.auswerten(message);
			}
		}
	}

	@Override
	public int getType() { return 8; }

}
