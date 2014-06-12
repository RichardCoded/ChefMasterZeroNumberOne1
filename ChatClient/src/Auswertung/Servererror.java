package Auswertung;

import java.util.ArrayList;

import Model.Message;
import View.IViewAktualisieren;

public class Servererror extends AbstractAuswertung
{

	private ArrayList<IServerErrorAuswerten> _servermessages = new ArrayList<IServerErrorAuswerten>()
	{
		{
			add(new Login(_view));
			add(new Logout(_view));
			add(new Join(_view));
			add(new Leave(_view));
			add(new Register(_view));
			add(new Chatmessage(_view));
		}
	};
	
	public Servererror(IViewAktualisieren view) 
	{
		super(view);		
	}

	@Override
	public void auswerten(Message message) 
	{
		for(IServerErrorAuswerten auswertungsklasse : this._servermessages)
		{
			System.out.println(auswertungsklasse.getClass().getSimpleName().toUpperCase());			
			if(message.getContent().contains(auswertungsklasse.getErrorType()))
			{
				auswertungsklasse.errorAuswerten(message);
			}
		}
	}

	@Override
	public int getType() 
	{
		return Message.SERVERERROR;
	}

}
