package Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

import Auswertung.AbstractAuswertung;
import Model.Message;

public class Controller implements Runnable
{
	//SUPER COOLE AENDERUNG BRO! 
	//private Attribute
	private ObjectInputStream _input;
    private ObjectOutputStream _output;
	private Socket _socket;
	private Thread _clientThread;
	private boolean _isConnectedToServer;
    private ArrayList<AbstractAuswertung> _kriterien = new ArrayList<AbstractAuswertung>();
	
	public Controller()
	{ }
	
	public void setAuswertungskriterien(ArrayList<AbstractAuswertung> kriterien)
	{
		this._kriterien = kriterien;
	}
	
	public void ConnectToServer(String serverAdresse, int port)
	{
		try 
		{
			this._socket = new Socket(InetAddress.getByName(serverAdresse), port);
			
			_output = new ObjectOutputStream(_socket.getOutputStream());
			_output.flush();
	        
			_input = new ObjectInputStream(_socket.getInputStream());
	        
			
			starteThread();
			
	        this._isConnectedToServer = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			this._isConnectedToServer = false;
			this.stoppeThread();
		}
	}

	public boolean getServerConnectionStatus()
	{
		return this._isConnectedToServer;
	}
	
	private void starteThread()
	{
		_clientThread = new Thread(this);
		_clientThread.start();
	}
	
	public void stoppeThread()
	{
		if(_clientThread != null)
		{
			_clientThread.stop();
		}		
	}

	public void sendMessageObject(Message message)
    {
        try 
        {
        	_output.writeObject(message);
        	_output.flush();
        }
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }
	
	@Override
	public void run()
	{		
		boolean read = true;
		while(read)
		{
			try 
			{
				
				Message message = (Message) _input.readObject();
								
				for(AbstractAuswertung kriterium : this._kriterien)
				{
					if(kriterium.getType() == message.getType())
					{
						kriterium.auswerten(message);
					}
				}
			}
			catch (Exception e) 
			{
				java.util.Date date= new java.util.Date();
           	 	System.out.println(date.getTime());
				read = false;
				e.printStackTrace();
			}
		}
		
	}
	
}
