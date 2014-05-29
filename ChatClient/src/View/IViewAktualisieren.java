package View;

import java.util.ArrayList;

public interface IViewAktualisieren 
{
	void ChatMessageEmpfangen(String message);
	void BenutzerListeErhalten(ArrayList<String> users);
	void RaeumeListeErhalten(ArrayList<String> rooms);
	
	void LoginErgebnis(boolean status, String result);
	void LogoutErgebnis(boolean status, String result);
	void RegistrierungErgebnis(boolean status, String result);
	
	//Noch klären, wie Join und Leave genau ablaufen. ps. Serverteam ist schwul. 
	void JoinErgebnis(boolean result);
	void LeaveErgebnis(boolean result);
}
