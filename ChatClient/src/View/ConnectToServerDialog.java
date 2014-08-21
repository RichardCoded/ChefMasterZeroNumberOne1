package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import Controller.Controller;

public class ConnectToServerDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtServerURL;
	private MainFrame mainframe;

	private Controller _controller;
	
	public ConnectToServerDialog(MainFrame mainframe, final Controller controller) 
	{
		this.mainframe = mainframe;

		this._controller = controller;

		setResizable(false);
		setTitle("Connect to Server");
		setSize(365, 150);
		setLocationRelativeTo(mainframe);
		// setBounds(100, 100, 365, 210);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Connection Properties",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 120, 120, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUsername = new JLabel("Server");
			GridBagConstraints gbc_lblUsername = new GridBagConstraints();
			gbc_lblUsername.anchor = GridBagConstraints.WEST;
			gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
			gbc_lblUsername.gridx = 1;
			gbc_lblUsername.gridy = 0;
			contentPanel.add(lblUsername, gbc_lblUsername);
		}
		{
			JLabel lblPassword = new JLabel("Port");
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.anchor = GridBagConstraints.WEST;
			gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
			gbc_lblPassword.gridx = 2;
			gbc_lblPassword.gridy = 0;
			contentPanel.add(lblPassword, gbc_lblPassword);
		}
		{
			txtServerURL = new JTextField();
			txtServerURL.setText("localhost");
			GridBagConstraints gbc_txtServerURL = new GridBagConstraints();
			gbc_txtServerURL.insets = new Insets(0, 0, 5, 5);
			gbc_txtServerURL.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtServerURL.gridx = 1;
			gbc_txtServerURL.gridy = 1;
			contentPanel.add(txtServerURL, gbc_txtServerURL);
			txtServerURL.setColumns(10);
		}
		{
			txtServerport = new JTextField();
			txtServerport.setText("13000");
			GridBagConstraints gbc_txtServerport = new GridBagConstraints();
			gbc_txtServerport.insets = new Insets(0, 0, 5, 5);
			gbc_txtServerport.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtServerport.gridx = 2;
			gbc_txtServerport.gridy = 1;
			contentPanel.add(txtServerport, gbc_txtServerport);
			txtServerport.setColumns(10);
		}
		{
			JLabel lblInfomessage = new JLabel(
					" Please fill in the credentials and press Login afterwads");
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
				JButton okButton = new JButton("Connect");
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		setModal(true);
		setVisible(true);
	}

	ActionListener register = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(!_controller.getServerConnectionStatus())
			{
				String serveraddress = "";
				int port;
				try 
				{
					serveraddress = txtServerURL.getText();
					port = Integer.valueOf(txtServerport.getText());
					
				}
				catch (Exception e2) 
				{
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Port muss ganzzahlig sein.");
					return;
				}
				if(!serveraddress.isEmpty())
				{
					_controller.ConnectToServer(serveraddress, port);					
					if(_controller.getServerConnectionStatus())
						mainframe.setModus("ConnectedToServer");
				}
				
			}
			dispose();
		}
	};
	private JTextField txtServerport;

}
