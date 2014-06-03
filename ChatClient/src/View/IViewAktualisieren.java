package View;

import java.util.ArrayList;

public interface IViewAktualisieren 
{
	void chatMessageEmpfangen(String message);
	void benutzerListeErhalten(ArrayList<String> users);
	void raeumeListeErhalten(ArrayList<String> rooms);
	
	void loginErgebnis(boolean status, String result, String name);
	void logoutErgebnis(boolean status, String result);
	void registrierungErgebnis(boolean status, String result);
	
	//Noch klären, wie Join und Leave genau ablaufen. ps. Serverteam ist schwul. 
	void joinErgebnis(boolean result);
	void leaveErgebnis(boolean result);
}
