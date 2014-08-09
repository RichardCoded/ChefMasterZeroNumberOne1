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
		
		int x = message.getContent().indexOf(": ", 0);
		String raumname = message.getContent().substring(x+2, message.getContent().length());
		System.out.println(raumname);
		_view.joinErgebnis(true, raumname, StaticServerAnswerResources.getChatOutputEvaluated(message).replaceFirst(this.getErrorType(), ""));
	}

	@Override
	public void errorAuswerten(Message message) 
	{
		_view.joinErgebnis(false,"", StaticServerAnswerResources.getChatOutputEvaluated(message).replaceFirst(this.getErrorType(), ""));
	}

	@Override
	public String getErrorType() 
	{
		return "JOIN:";
	}
}
