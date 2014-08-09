package View;

import java.util.ArrayList;

public interface IViewAktualisieren 
{
	void chatMessageEmpfangen(String message);
	void benutzerListeErhalten(ArrayList<String> users);
	void raeumeListeErhalten(ArrayList<String> rooms);
	
	void loginErgebnis(boolean eingeloggt, String inhalt, String benutzername);
	void logoutErgebnis(boolean ausgeloggt, String inhalt);
	void registrierungErgebnis(String inhalt);
	
	void joinErgebnis(boolean joined, String raumname, String inhalt);
	void leaveErgebnis(boolean left, String inhalt);
}
