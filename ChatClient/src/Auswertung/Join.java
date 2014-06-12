package Auswertung;

import Model.Message;
import View.IViewAktualisieren;

public class Join implements IMessageAuswerten, IServerErrorAuswerten
{
	private IViewAktualisieren _view;
	public Join(IViewAktualisieren view)
	{
		this._view = view;
	}

	@Override
	public void auswerten(Message message) 
	{
		if(message.getContent().contains("successful"))
		{
			_view.joinErgebnis(true);
		}
		else if(message.getContent().contains(StaticServerAnswerResources.Fehlgeschlagen))
		{
			_view.joinErgebnis(false);
		}
	}

	@Override
	public void errorAuswerten(Message message) 
	{
		
	}

	@Override
	public String getErrorType() 
	{
		return "JOIN:";
	}
}
