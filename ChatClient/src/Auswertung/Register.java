package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Register implements IMessageAuswerten, IServerErrorAuswerten
{
	private IViewAktualisieren _view;
	public Register(IViewAktualisieren view)
	{
		this._view = view;
	}

	@Override
	public void auswerten(Message message) 
	{
		System.out.println("Client: "+message.getContent());
	}

	@Override
	public void errorAuswerten(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getErrorType() 
	{
		return "REGISTER:";
	}
	
	
}
