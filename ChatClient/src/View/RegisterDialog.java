package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import Controller.Controller;
import Model.Message;

public class RegisterDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private MainFrame mainframe;
	
	private Controller _controller;
	


	public RegisterDialog(MainFrame mainframe, final Controller controller) {
		
		
		
		
		
		
this.mainframe = mainframe;
		
		this._controller = controller;
		
		setResizable(false);
		setTitle("Register");
		setSize(365,150);
		setLocationRelativeTo(mainframe);
//		setBounds(100, 100, 365, 210);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Register", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 120, 120, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUsername = new JLabel("Username");
			GridBagConstraints gbc_lblUsername = new GridBagConstraints();
			gbc_lblUsername.anchor = GridBagConstraints.WEST;
			gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
			gbc_lblUsername.gridx = 1;
			gbc_lblUsername.gridy = 0;
			contentPanel.add(lblUsername, gbc_lblUsername);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.anchor = GridBagConstraints.WEST;
			gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
			gbc_lblPassword.gridx = 2;
			gbc_lblPassword.gridy = 0;
			contentPanel.add(lblPassword, gbc_lblPassword);
		}
		{
			txtUsername = new JTextField();
			txtUsername.setText("Username");
			GridBagConstraints gbc_txtUsername = new GridBagConstraints();
			gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
			gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUsername.gridx = 1;
			gbc_txtUsername.gridy = 1;
			contentPanel.add(txtUsername, gbc_txtUsername);
			txtUsername.setColumns(10);
		}
		{
			txtPassword = new JPasswordField();
			txtPassword.setText("Password");
			GridBagConstraints gbc_txtPassword = new GridBagConstraints();
			gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
			gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPassword.gridx = 2;
			gbc_txtPassword.gridy = 1;
			contentPanel.add(txtPassword, gbc_txtPassword);
			txtPassword.setColumns(10);
		}
		{
			JLabel lblInfomessage = new JLabel(" Please fill in the credentials and press Login afterwads");
			GridBagConstraints gbc_lblInfomessage = new GridBagConstraints();
			gbc_lblInfomessage.anchor = GridBagConstraints.NORTH;
			gbc_lblInfomessage.gridwidth = 4;
			gbc_lblInfomessage.gridx = 0;
			gbc_lblInfomessage.gridy = 2;
			contentPanel.add(lblInfomessage, gbc_lblInfomessage);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Register");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(register);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(cancelButton);
				
			}
		}
		this.setModal(true);
		setVisible(true);
	}
	
	ActionListener register = new ActionListener() 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
//			if(!_controller.getServerConnectionStatus())
//			{
//				String serveraddress = "";
//				int port;
//				try 
//				{
//					serveraddress = txtServer.getText();
//					port = Integer.valueOf(txtPort.getText());
//					
//				}
//				catch (Exception e2) 
//				{
//					e2.printStackTrace();
//					JOptionPane.showMessageDialog(null, "Port muss ganzzahlig sein.");
//					return;
//				}
//				if(!serveraddress.isEmpty())
//				_controller.ConnectToServer(serveraddress, port);
//			}
			
			String username = txtUsername.getText();
			String passwort = txtPassword.getText();
			
//			_controller.sendMessageObject((new Message(7, username, "asdf", "", "")));
			_controller.sendMessageObject((new Message(7, username, passwort, "", "")));
			
			mainframe.myUserName = username;
			dispose();
		}
	};
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
