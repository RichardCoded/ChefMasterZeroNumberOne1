package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class RegisterDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField txtServer;
	private JTextField txtPort;
	private MainFrame mainframe;
	public RegisterDialog(MainFrame mainframe) {
		this.mainframe = mainframe;
		setResizable(false);
		setTitle("Register");
		setSize(365,210);
		setLocationRelativeTo(mainframe);
//		setBounds(100, 100, 365, 210);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Register", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 120, 120, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblServer = new JLabel("Server");
			GridBagConstraints gbc_lblServer = new GridBagConstraints();
			gbc_lblServer.anchor = GridBagConstraints.WEST;
			gbc_lblServer.insets = new Insets(0, 0, 5, 5);
			gbc_lblServer.gridx = 1;
			gbc_lblServer.gridy = 0;
			contentPanel.add(lblServer, gbc_lblServer);
		}
		{
			JLabel lblPort = new JLabel("Port");
			GridBagConstraints gbc_lblPort = new GridBagConstraints();
			gbc_lblPort.insets = new Insets(0, 0, 5, 5);
			gbc_lblPort.anchor = GridBagConstraints.WEST;
			gbc_lblPort.gridx = 2;
			gbc_lblPort.gridy = 0;
			contentPanel.add(lblPort, gbc_lblPort);
		}
		{
			txtServer = new JTextField();
			txtServer.setText("Server");
			GridBagConstraints gbc_txtServer = new GridBagConstraints();
			gbc_txtServer.insets = new Insets(0, 0, 5, 5);
			gbc_txtServer.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtServer.gridx = 1;
			gbc_txtServer.gridy = 1;
			contentPanel.add(txtServer, gbc_txtServer);
			txtServer.setColumns(10);
		}
		{
			txtPort = new JTextField();
			txtPort.setText("Port");
			GridBagConstraints gbc_txtPort = new GridBagConstraints();
			gbc_txtPort.insets = new Insets(0, 0, 5, 5);
			gbc_txtPort.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPort.gridx = 2;
			gbc_txtPort.gridy = 1;
			contentPanel.add(txtPort, gbc_txtPort);
			txtPort.setColumns(10);
		}
		{
			JLabel lblUsername = new JLabel("Username");
			GridBagConstraints gbc_lblUsername = new GridBagConstraints();
			gbc_lblUsername.anchor = GridBagConstraints.WEST;
			gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
			gbc_lblUsername.gridx = 1;
			gbc_lblUsername.gridy = 2;
			contentPanel.add(lblUsername, gbc_lblUsername);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.anchor = GridBagConstraints.WEST;
			gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
			gbc_lblPassword.gridx = 2;
			gbc_lblPassword.gridy = 2;
			contentPanel.add(lblPassword, gbc_lblPassword);
		}
		{
			txtUsername = new JTextField();
			txtUsername.setText("Username");
			GridBagConstraints gbc_txtUsername = new GridBagConstraints();
			gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
			gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUsername.gridx = 1;
			gbc_txtUsername.gridy = 3;
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
			gbc_txtPassword.gridy = 3;
			contentPanel.add(txtPassword, gbc_txtPassword);
			txtPassword.setColumns(10);
		}
		{
			JLabel lblInfo = new JLabel("Info");
			GridBagConstraints gbc_lblInfo = new GridBagConstraints();
			gbc_lblInfo.anchor = GridBagConstraints.WEST;
			gbc_lblInfo.insets = new Insets(0, 0, 5, 5);
			gbc_lblInfo.gridx = 1;
			gbc_lblInfo.gridy = 4;
			contentPanel.add(lblInfo, gbc_lblInfo);
		}
		{
			JLabel lblInfomessage = new JLabel(" Please fill in the credentials and press Login afterwads");
			GridBagConstraints gbc_lblInfomessage = new GridBagConstraints();
			gbc_lblInfomessage.anchor = GridBagConstraints.NORTH;
			gbc_lblInfomessage.gridwidth = 4;
			gbc_lblInfomessage.insets = new Insets(0, 0, 0, 5);
			gbc_lblInfomessage.gridx = 0;
			gbc_lblInfomessage.gridy = 5;
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
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}

}
