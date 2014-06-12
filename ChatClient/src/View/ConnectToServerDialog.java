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
			txtServerURL.setText("ServerURL");
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
			txtServerport.setText("1337");
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
				JButton okButton = new JButton("Register");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(register);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}

	ActionListener register = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			dispose();
		}
	};
	private JTextField txtServerport;

}
