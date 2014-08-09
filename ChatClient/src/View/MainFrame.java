package View;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;

import javax.swing.JTextPane;

import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;

import java.awt.Dimension;

import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.AbstractListModel;

import Auswertung.AbstractAuswertung;
import Auswertung.Benutzer;
import Auswertung.Chatmessage;
import Auswertung.IMessageAuswerten;
import Auswertung.Raeume;
import Auswertung.Register;
import Auswertung.Servererror;
import Auswertung.Serversuccess;
import Controller.Controller;
import Model.Message;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class MainFrame extends JFrame implements IViewAktualisieren {
	private JScrollPane spChatlog;
	private JTextPane tfChatlog;
	private JScrollPane spRooms;
	private JList liRooms;
	private JScrollPane spUsers;
	private JList liUsers;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnConnection;
	private JMenu mnHelp;
	private JScrollPane spSubmit;
	private JTextPane tfSubmit;
	private JButton btnSend;
	private JMenuItem mntmCommandlist;
	private JMenuItem mntmAbout;
	private JMenuItem mntmConnectToServer;	
	private JMenuItem mntmLogin;
	private JMenuItem mntmRegister;
	private JMenuItem mntmClose;
	private JMenuItem mntmLogout;
	private JPanel panel;
	private JTextField tfServerPort;
	private JTextField txtMainlobby;
	private JTextField txtUser;

	public String myUserName = "";
	private String _zielUserName = "";
	private String _raumname = "mainlobby";
	
	private StringBuffer _chatlog = new StringBuffer();
	
	private Controller _controller;
	private ArrayList<AbstractAuswertung> _auswertungskriterien;
	
	private void setAuswertungskriterien()
	{
		final IViewAktualisieren view = this;
		_auswertungskriterien = new ArrayList<AbstractAuswertung>()
		{
			{
				add(new Chatmessage(view));				
				add(new Benutzer(view));
				add(new Raeume(view));
				add(new Serversuccess(view));
				add(new Servererror(view));
			}			
		};
		
		this._controller.setAuswertungskriterien(_auswertungskriterien);
	}
	
	public String getUsername()
	{
		return this.myUserName;
	}
	
	public void setUsername(String username)
	{
		this.myUserName = username;
	}
	
	public MainFrame(Controller controller) 
	{
		this._controller = controller;
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (final Exception e) {
			System.out.println("Look & Feel konnte nicht geladen werden.");
		}

		
		
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 436, 147, 0 };
		gridBagLayout.rowHeights = new int[] { 23, 108, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(5, 5, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(getPanel(), gbc_panel);
		GridBagConstraints gbc_spChatlog = new GridBagConstraints();
		gbc_spChatlog.gridheight = 2;
		gbc_spChatlog.insets = new Insets(0, 5, 5, 5);
		gbc_spChatlog.fill = GridBagConstraints.BOTH;
		gbc_spChatlog.gridx = 0;
		gbc_spChatlog.gridy = 1;
		getContentPane().add(getSpChatlog(), gbc_spChatlog);
		GridBagConstraints gbc_spRooms = new GridBagConstraints();
		gbc_spRooms.insets = new Insets(0, 0, 5, 5);
		gbc_spRooms.fill = GridBagConstraints.BOTH;
		gbc_spRooms.gridx = 1;
		gbc_spRooms.gridy = 1;
		getContentPane().add(getSpRooms(), gbc_spRooms);
		GridBagConstraints gbc_spUsers = new GridBagConstraints();
		gbc_spUsers.gridheight = 2;
		gbc_spUsers.insets = new Insets(0, 0, 5, 5);
		gbc_spUsers.fill = GridBagConstraints.BOTH;
		gbc_spUsers.gridx = 1;
		gbc_spUsers.gridy = 2;
		getContentPane().add(getSpUsers(), gbc_spUsers);
		GridBagConstraints gbc_spSubmit = new GridBagConstraints();
		gbc_spSubmit.gridheight = 2;
		gbc_spSubmit.insets = new Insets(0, 5, 5, 5);
		gbc_spSubmit.fill = GridBagConstraints.BOTH;
		gbc_spSubmit.gridx = 0;
		gbc_spSubmit.gridy = 3;
		getContentPane().add(getSpSubmit(), gbc_spSubmit);
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.insets = new Insets(0, 0, 5, 5);
		gbc_btnSend.fill = GridBagConstraints.BOTH;
		gbc_btnSend.gridx = 1;
		gbc_btnSend.gridy = 4;
		getContentPane().add(getBtnSend(), gbc_btnSend);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0, 0, 640, 480);
		setJMenuBar(getMenuBar_1());
		setVisible(true);
		
		
		
		this.setModus("AppStart");
		this.setAuswertungskriterien();
		this.addWindowListener(windowListener);
	}

	private JScrollPane getSpChatlog() 
	{
		if (spChatlog == null) 
		{
			spChatlog = new JScrollPane();
			spChatlog.setViewportView(getTfChatlog());
		}
		return spChatlog;
	}
	
	private JTextPane getTfChatlog() 
	{
		if (tfChatlog == null) 
		{
			tfChatlog = new JTextPane();
			tfChatlog.setEditable(false);
		}
		return tfChatlog;
	}
	
	private JScrollPane getSpRooms() 
	{
		if (spRooms == null) 
		{
			spRooms = new JScrollPane();
			spRooms.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			spRooms.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			spRooms.setBorder(new TitledBorder(null, "Rooms", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			spRooms.setViewportView(getLiRooms());
		}
		return spRooms;
	}
	
	private JList getLiRooms() 
	{
		if (liRooms == null) 
		{
			liRooms = new JList();
		}
		return liRooms;
	}
	
	private JScrollPane getSpUsers() 
	{
		if (spUsers == null) 
		{
			spUsers = new JScrollPane();
			spUsers.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			spUsers.setBorder(new TitledBorder(null, "Users", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			spUsers.setViewportView(getLiUsers());
		}
		return spUsers;
	}
	
	private JList getLiUsers() 
	{
		if (liUsers == null) 
		{
			liUsers = new JList();
			liUsers.addListSelectionListener(selectedUserChanged);
		}
		return liUsers;
	}
	private JMenuBar getMenuBar_1() 
	{
		if (menuBar == null) 
		{
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnConnection());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() 
	{
		if (mnFile == null) 
		{
			mnFile = new JMenu("File");
			mnFile.add(getMntmClose());
		}
		return mnFile;
	}
	private JMenu getMnConnection() 
	{
		if (mnConnection == null) 
		{
			mnConnection = new JMenu("Connection");
			mnConnection.add(getMntmConnectToServer());
			mnConnection.add(getMntmRegister());
			mnConnection.add(getMntmLogin());
			mnConnection.add(getMntmLogout());
		}
		return mnConnection;
	}
	private JMenu getMnHelp() 
	{
		if (mnHelp == null) 
		{
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmCommandlist());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JScrollPane getSpSubmit() 
	{
		if (spSubmit == null) 
		{
			spSubmit = new JScrollPane();
			spSubmit.setViewportView(getTfSubmit());			
		}
		return spSubmit;
	}
	private JTextPane getTfSubmit() 
	{
		if (tfSubmit == null) 
		{
			tfSubmit = new JTextPane();			
			tfSubmit.setText("");
			tfSubmit.addKeyListener(new KeyAdapter() 
			{
				@Override
		        public void keyPressed(KeyEvent e) 
				{
					if (e.getKeyCode() == 10) 
		            {
						sendMessage(); // Fügt Zeilenumbruch hinzu, was buggy ist.
		            }
		        }
			});
			
		}
		return tfSubmit;
	}
	private JButton getBtnSend() 
	{
		if (btnSend == null) 
		{
			btnSend = new JButton("Send");
			btnSend.addActionListener(sendMessageListener);
		}
		return btnSend;
	}
	private JMenuItem getMntmCommandlist() 
	{
		if (mntmCommandlist == null) 
		{
			mntmCommandlist = new JMenuItem("Commandlist");
			mntmCommandlist.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					new CommandlistDialog(MainFrame.this);
				}
			});
		}
		return mntmCommandlist;
	}
	private JMenuItem getMntmAbout() 
	{
		if (mntmAbout == null) 
		{
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					new AboutDialog(MainFrame.this);
				}
			});
		}
		return mntmAbout;
	}
	private JMenuItem getMntmConnectToServer() 
	{
		if (mntmConnectToServer == null) 
		{
			mntmConnectToServer = new JMenuItem("Connect to Server");
			mntmConnectToServer.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					new ConnectToServerDialog(MainFrame.this, _controller);
					if(_controller.getServerConnectionStatus())
						tfServerPort.setText(_controller.getServerPort());
				}
			});
		}
		return mntmConnectToServer;
	}	
	private JMenuItem getMntmLogin() 
	{
		if (mntmLogin == null) 
		{
			mntmLogin = new JMenuItem("Login");
			mntmLogin.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					new LoginDialog(MainFrame.this, _controller);
				}
			});
		}
		return mntmLogin;
	}
	private JMenuItem getMntmRegister() 
	{
		if (mntmRegister == null) 
		{
			mntmRegister = new JMenuItem("Register");
			mntmRegister.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					new RegisterDialog(MainFrame.this, _controller);
				}
			});
		}
		return mntmRegister;
	}
	
	private JMenuItem getMntmLogout()
	{
		if(mntmLogout == null)
		{
			mntmLogout = new JMenuItem("Logout");
			mntmLogout.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					_controller.sendMessageObject(new Message(6,myUserName,"", "", ""));					
				}
			});
			
		}
		return mntmLogout;
	}
	
	private JMenuItem getMntmClose() 
	{
		if (mntmClose == null) 
		{
			mntmClose = new JMenuItem("Close");
			mntmClose.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					_controller.stoppeThread();
					MainFrame.this.dispose();
				}
			});
		}
		return mntmClose;
	}
	private JPanel getPanel() 
	{
		if (panel == null) 
		{
			panel = new JPanel();
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			panel.add(getTfServerPort());
			panel.add(getTxtMainlobby());
			panel.add(getTxtUser());
		}
		return panel;
	}
	private JTextField getTfServerPort() 
	{
		if (tfServerPort == null) 
		{
			tfServerPort = new JTextField();
			tfServerPort.setText("");
			tfServerPort.setBorder(new TitledBorder(null, "Server : Port", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			tfServerPort.setEditable(false);
			tfServerPort.setColumns(10);
		}
		return tfServerPort;
	}
	private JTextField getTxtMainlobby() 
	{
		if (txtMainlobby == null) 
		{
			txtMainlobby = new JTextField();
			txtMainlobby.setBorder(new TitledBorder(null, "Room", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtMainlobby.setEditable(false);
			txtMainlobby.setText("");
			txtMainlobby.setColumns(10);
		}
		return txtMainlobby;
	}
	private JTextField getTxtUser() 
	{
		if (txtUser == null) 
		{
			txtUser = new JTextField();
			txtUser.setEditable(false);
			txtUser.setBorder(new TitledBorder(null, "User", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtUser.setText("");
			txtUser.setColumns(10);
		}
		return txtUser;
	}

	public void sendMessageObject(Message message)
	{
		this._controller.sendMessageObject(message);
	}

	@Override
	public void chatMessageEmpfangen(String message) 
	{		
		_chatlog.append(message+"\n");
		tfChatlog.setText(_chatlog.toString());		
	}


	@Override
	public void benutzerListeErhalten(ArrayList<String> users) 
	{
		DefaultListModel benutzer = new DefaultListModel();
		for(String string : users)
		{
			benutzer.addElement(string);
		}
		benutzer.removeElement(txtUser.getText());
		this.liUsers.setModel(benutzer);		
	}


	@Override
	public void raeumeListeErhalten(ArrayList<String> rooms) 
	{
		DefaultListModel raeume = new DefaultListModel();
		for(String string : rooms)
		{
			raeume.addElement(string);
		}
		
		this.liRooms.setModel(raeume);		
	}


	@Override
	public void loginErgebnis(boolean eingeloggt, String inhalt, String benutzername) 
	{
		if(eingeloggt)
		{
			myUserName = benutzername;
			txtUser.setText(benutzername);
						
			_chatlog.append(inhalt+"\n");
			tfChatlog.setText(_chatlog.toString());
			
			//join mainlobby after login
			sendMessageObject(new Message(3, myUserName, "mainlobby","", ""));
			this.setModus("LoggedIn");
		}
		else
		{			
			_chatlog.append(inhalt+"\n");
			tfChatlog.setText(_chatlog.toString());
		}
		
	}
	

	@Override
	public void logoutErgebnis(boolean ausgeloggt, String inhalt) 
	{
		if(ausgeloggt)
		{
			txtUser.setText("");
			txtMainlobby.setText("");			
			_chatlog.append(inhalt+"\n");
			tfChatlog.setText(_chatlog.toString());
			tfSubmit.setText("");
			liRooms.setModel(new DefaultListModel());
			liUsers.setModel(new DefaultListModel());
			
			//entsprechende Elemente entsperren
			this.setModus("LoggedOut");
		}
	}

	@Override
	public void registrierungErgebnis(String inhalt) 
	{			
		tfChatlog.setText(_chatlog.append(inhalt+"\n").toString());	
	}

	@Override
	public void joinErgebnis(boolean joined, String raumname, String inhalt) 
	{
		if(joined)
		txtMainlobby.setText(raumname);		
		tfChatlog.setText(_chatlog.append(inhalt+"\n").toString());
	}

	@Override
	public void leaveErgebnis(boolean left, String inhalt) 
	{
		if(left)
		tfChatlog.setText(_chatlog.append(inhalt+"\n").toString());			
	}
	
	
	private void sendMessage()
	{
		String text;
		if(tfSubmit.getText().length() > 0)
		{
			String firstLetter = tfSubmit.getText().substring(0,1);
			if(firstLetter.equals("/"))
			{
				if(tfSubmit.getText().length() >= 6)
				{
					String leave = tfSubmit.getText().substring(1,6);
					if(leave.equals("leave"))
					{
						System.out.println(txtMainlobby.getText());
						
						if (txtMainlobby.getText().equals("mainlobby")) 
						{
							tfChatlog.setText(_chatlog.append("[Client -> Me] : You are already in the mainlobby"+"\n").toString());
							tfSubmit.setText("");
							return;
						}
						
						sendMessageObject(new Message(4, myUserName, txtMainlobby.getText(),"", txtMainlobby.getText()));
						sendMessageObject(new Message(3, myUserName, "mainlobby","", ""));
					}
					if(leave.equals("reset"))
					{
						myUserName =  txtUser.getText();							
					}
					
					
					String join = tfSubmit.getText().substring(1,5);						
					if(join.equals("join"))
					{
						int length = tfSubmit.getText().length();
						
						String leerzeichen = tfSubmit.getText().substring(5,6);
						
						if(leerzeichen.equals(" "))
						{
							text = tfSubmit.getText().substring(6, length);								
						}
						else
						{
							text = tfSubmit.getText().substring(5, length);
						}
						
						_raumname = text;
						sendMessageObject(new Message(4, myUserName, txtMainlobby.getText(),"", txtMainlobby.getText()));
						sendMessageObject(new Message(3, myUserName, text,"", ""));
					}
					
					String name = tfSubmit.getText().substring(1,5);
					if(name.equals("name"))
					{
						myUserName = tfSubmit.getText().substring(6, tfSubmit.getText().length());
						
					}
					tfSubmit.setText("");
					return;
				}
			}
			//return; // alternativ
		}
		
		text = tfSubmit.getText();
		
		if(text.replaceAll(" ", "").length() == 0)
			return;
		
		//send Message if user is being selected
		if(!_zielUserName.isEmpty())
		{
			sendMessageObject(new Message(0, myUserName, text, _zielUserName, ""));
//			sendMessageObject(new Message(0, myUserName, text, "Richard", ""));
			
			if(!myUserName.equals(txtUser.getText()))
			{
				//sendMessageObject(new Message(0, "Me", text, myUserName, ""));
				return; //mister x
			}
			text = "[Me -> "+_zielUserName+"] : "+text;
			
			_chatlog.append(text+"\n");
			tfChatlog.setText(_chatlog.toString());
		}
		else
		{
			sendMessageObject(new Message(0, myUserName, text, null, txtMainlobby.getText()));
							
//			_chatlog.append("[Me -> "+_raumname+"] : "+text+"\n");
//			tfChatlog.setText(_chatlog.toString());
			
		}
		tfSubmit.setText("");
	}
	
	
	ActionListener sendMessageListener = new ActionListener() 
	{	
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{		
			sendMessage();			
		}
	};
	
	ListSelectionListener selectedUserChanged = new ListSelectionListener() 
	{		
		@Override
		public void valueChanged(ListSelectionEvent e) 
		{
			if(liUsers.getSelectedValue() != null)
				_zielUserName = liUsers.getSelectedValue().toString();
			else
				_zielUserName = "";
		}
	};

	private WindowListener windowListener = new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) 
		{
			sendMessageObject(new Message(6,myUserName,"", "", ""));
			
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			sendMessageObject(new Message(6,myUserName,"", "", ""));
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	};
	
	
	
	public void setModus(String modus)
	{
		ArrayList elements;
		if(modus.equals("AppStart"))
		{
			tfSubmit.setEnabled(false);
			btnSend.setEnabled(false);
			mntmRegister.setEnabled(false);
			mntmLogin.setEnabled(false);
			mntmLogout.setEnabled(false);
		}
		else if(modus.equals("ConnectedToServer"))
		{
			mntmConnectToServer.setEnabled(false);
			mntmRegister.setEnabled(true);
			mntmLogin.setEnabled(true);				
		}
		else if(modus.equals("LoggedIn"))
		{
			mntmRegister.setEnabled(false);
			mntmLogin.setEnabled(false);
			mntmLogout.setEnabled(true);
			tfSubmit.setEnabled(true);
			btnSend.setEnabled(true);
		}
		else if(modus.equals("LoggedOut"))
		{
			mntmRegister.setEnabled(true);
			mntmLogin.setEnabled(true);
			mntmLogout.setEnabled(false);
			tfSubmit.setEnabled(false);
			btnSend.setEnabled(false);
		}
	}
}
