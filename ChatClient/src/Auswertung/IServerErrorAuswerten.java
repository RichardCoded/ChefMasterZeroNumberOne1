package Auswertung;

import Model.Message;

public interface IServerErrorAuswerten 
{
	void errorAuswerten(Message message);
	String getErrorType();
	
}
