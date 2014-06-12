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
		
		this.setAuswertungskriterien();
	}

	
	private JScrollPane getSpChatlog() {
		if (spChatlog == null) {
			spChatlog = new JScrollPane();
			spChatlog.setViewportView(getTfChatlog());
		}
		return spChatlog;
	}
	private JTextPane getTfChatlog() {
		if (tfChatlog == null) {
			tfChatlog = new JTextPane();
		}
		return tfChatlog;
	}
	private JScrollPane getSpRooms() {
		if (spRooms == null) {
			spRooms = new JScrollPane();
			spRooms.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			spRooms.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			spRooms.setBorder(new TitledBorder(null, "Rooms", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			spRooms.setViewportView(getLiRooms());
		}
		return spRooms;
	}
	private JList getLiRooms() {
		if (liRooms == null) {
			liRooms = new JList();
			liRooms.setModel(new AbstractListModel() {
				String[] values = new String[] {"Mainlobby", "I am so drunk", "Relentless zum Fr\u00FChst\u00FCck"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
		return liRooms;
	}
	private JScrollPane getSpUsers() {
		if (spUsers == null) {
			spUsers = new JScrollPane();
			spUsers.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			spUsers.setBorder(new TitledBorder(null, "Users", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			spUsers.setViewportView(getLiUsers());
		}
		return spUsers;
	}
	private JList getLiUsers() {
		if (liUsers == null) {
			liUsers = new JList();
			liUsers.addListSelectionListener(selectedUserChanged);
			liUsers.setModel(new AbstractListModel() {
				String[] values = new String[] {"Azad", "Bushido", "Cool Savage", "Sammy Deluxe", "Ash aus Alabastia"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
		return liUsers;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnConnection());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmClose());
		}
		return mnFile;
	}
	private JMenu getMnConnection() {
		if (mnConnection == null) {
			mnConnection = new JMenu("Connection");
			mnConnection.add(getMntmConnectToServer());
			mnConnection.add(getMntmRegister());
			mnConnection.add(getMntmLogin());
			mnConnection.add(getMntmLogout());
		}
		return mnConnection;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmCommandlist());
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JScrollPane getSpSubmit() {
		if (spSubmit == null) {
			spSubmit = new JScrollPane();
			spSubmit.setViewportView(getTfSubmit());
		}
		return spSubmit;
	}
	private JTextPane getTfSubmit() {
		if (tfSubmit == null) {
			tfSubmit = new JTextPane();
			tfSubmit.setText("tfSubmit");
		}
		return tfSubmit;
	}
	private JButton getBtnSend() {
		if (btnSend == null) {
			btnSend = new JButton("Send");
			btnSend.addActionListener(sendMessage);
		}
		return btnSend;
	}
	private JMenuItem getMntmCommandlist() {
		if (mntmCommandlist == null) {
			mntmCommandlist = new JMenuItem("Commandlist");
			mntmCommandlist.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CommandlistDialog(MainFrame.this);
				}
			});
		}
		return mntmCommandlist;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AboutDialog(MainFrame.this);
				}
			});
		}
		return mntmAbout;
	}
	private JMenuItem getMntmLogin() {
		if (mntmLogin == null) {
			mntmLogin = new JMenuItem("Login");
			mntmLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new LoginDialog(MainFrame.this, _controller);
				}
			});
		}
		return mntmLogin;
	}
	private JMenuItem getMntmRegister() {
		if (mntmRegister == null) {
			mntmRegister = new JMenuItem("Register");
			mntmRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
					//new LogoutDialog????					
				}
			});
			
		}
		return mntmLogout;
	}
	private JMenuItem getMntmClose() {
		if (mntmClose == null) {
			mntmClose = new JMenuItem("Close");
			mntmClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainFrame.this.dispose();
				}
			});
		}
		return mntmClose;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			panel.add(getTfServerPort());
			panel.add(getTxtMainlobby());
			panel.add(getTxtUser());
		}
		return panel;
	}
	private JTextField getTfServerPort() {
		if (tfServerPort == null) {
			tfServerPort = new JTextField();
			tfServerPort.setText("192.168.777 : 1337");
			tfServerPort.setBorder(new TitledBorder(null, "Server : Port", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			tfServerPort.setEditable(false);
			tfServerPort.setColumns(10);
		}
		return tfServerPort;
	}
	private JTextField getTxtMainlobby() {
		if (txtMainlobby == null) {
			txtMainlobby = new JTextField();
			txtMainlobby.setBorder(new TitledBorder(null, "Room", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtMainlobby.setEditable(false);
			txtMainlobby.setText("mainlobby");
			txtMainlobby.setColumns(10);
		}
		return txtMainlobby;
	}
	private JTextField getTxtUser() {
		if (txtUser == null) {
			txtUser = new JTextField();
			txtUser.setEditable(false);
			txtUser.setBorder(new TitledBorder(null, "User", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			txtUser.setText("Bushido");
			txtUser.setColumns(10);
		}
		return txtUser;
	}

	public void sendMessage(Message message)
	{
		this._controller.sendMessageObject(message);
	}

	@Override
	public void chatMessageEmpfangen(String message) 
	{
		String text = tfChatlog.getText()+"\n"+message;
		tfChatlog.setText(text);
		
	}


	@Override
	public void benutzerListeErhalten(ArrayList<String> users) 
	{
		DefaultListModel benutzer = new DefaultListModel();
		for(String string : users)
		{
			benutzer.addElement(string);
		}
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
	public void loginErgebnis(boolean status, String result, String name) 
	{
		if(status)
		{
			
			myUserName = name;
			txtUser.setText(name);
			_chatlog.append(result);
			tfChatlog.setText(_chatlog.toString());
		}
		else
		{
			String chat = tfChatlog.getText();
			chat = chat + "\n" + result;
			tfChatlog.setText(chat);
		}
		
		
	}


	@Override
	public void logoutErgebnis(boolean status, String result) 
	{
		if(!status)
		{
			txtUser.setText("");
			txtMainlobby.setText("");
			String chat = tfChatlog.getText();
			chat = chat + "\n" + result;
		}
	}


	@Override
	public void registrierungErgebnis(boolean status, String result) 
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void joinErgebnis(boolean result) 
	{
		if(result)
		txtMainlobby.setText(_raumname);
	}


	@Override
	public void leaveErgebnis(boolean result) 
	{
		if(result)
		{
			txtMainlobby.setText("mainlobby");
		}
		
	}
	
	ActionListener sendMessage = new ActionListener() 
	{	
		int x = 0;
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{		
			x++;
			System.out.println(x);
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
							_controller.sendMessageObject(new Message(4, myUserName, "","", ""));
							return;
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
							
							_controller.sendMessageObject(new Message(3, myUserName, text,"", ""));
							return;
						}
					}
				}
			}
			
			text = tfSubmit.getText();
			//send Message if user is being selected
			if(!_zielUserName.isEmpty())
			{				
				text = "[Me -> "+_zielUserName+"] : "+text;
				
				_controller.sendMessageObject(new Message(0, myUserName, text, _zielUserName, ""));
				
				String chatlog = tfChatlog.getText();
				tfChatlog.setText(chatlog + "\n" + text);
				return;
			}
			else
			{
				if(txtMainlobby.getText().equals("mainlobby"))
				{
					_controller.sendMessageObject(new Message(0, myUserName, text, "", ""));
				}
				else
				{
					_controller.sendMessageObject(new Message(0, myUserName, text, "", txtMainlobby.getText()));
				}
				
				System.out.println(txtMainlobby.getText());
				
				text = "[Me -> "+_raumname+"] : "+text;
				String chatlog = tfChatlog.getText();
				tfChatlog.setText(chatlog + "\n" + text);
				return;
			}
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
	private JMenuItem mntmConnectToServer;
	
	
	
	private JMenuItem getMntmConnectToServer() {
		if (mntmConnectToServer == null) {
			mntmConnectToServer = new JMenuItem("Connect to Server");
			mntmConnectToServer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new ConnectToServerDialog(MainFrame.this, _controller);
				}
			});
		}
		return mntmConnectToServer;
	}
}
