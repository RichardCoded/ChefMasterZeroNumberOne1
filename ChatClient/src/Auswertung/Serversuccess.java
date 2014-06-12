package Auswertung;

import java.util.ArrayList;

import Model.Message;
import View.IViewAktualisieren;

public class Serversuccess extends AbstractAuswertung {
	
	private ArrayList<IMessageAuswerten> _servermessages = new ArrayList<IMessageAuswerten>();
	private void setServerMessage()
	{
		this._servermessages = new ArrayList<IMessageAuswerten>()
		{
			{
				add(new Register(_view));
				add(new Login(_view));
				add(new Logout(_view));
				add(new Join(_view));
				add(new Leave(_view));
			}
		};
	}
	
	public Serversuccess(IViewAktualisieren view) 
	{
		super(view);
		setServerMessage();
	}

	@Override
	public void auswerten(Message message) 
	{		
		
		for(IMessageAuswerten auswertungsklasse : this._servermessages)
		{
			System.out.println(auswertungsklasse.getClass().getSimpleName().toUpperCase());
			if(message.getContent().contains(auswertungsklasse.getClass().getSimpleName().toUpperCase()))
			{
				auswertungsklasse.auswerten(message);
			}
		}
	}

	@Override
	public int getType() { return Message.SERVERSUCCESS; }

}
