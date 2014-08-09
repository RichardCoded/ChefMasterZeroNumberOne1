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

public class CommandlistDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPort;
	private JTextField txtjoin;
	private JTextField txtjoin_1;
	private JTextField txtleave;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField;
	private MainFrame mainframe;
	public CommandlistDialog(MainFrame mainframe) {
		this.mainframe = mainframe;
		setResizable(false);
		setTitle("Register");
		setSize(365, 465);
		setLocationRelativeTo(mainframe);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Commandlist", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 120, 120, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblServer = new JLabel("Decription");
			GridBagConstraints gbc_lblServer = new GridBagConstraints();
			gbc_lblServer.anchor = GridBagConstraints.WEST;
			gbc_lblServer.insets = new Insets(0, 0, 5, 5);
			gbc_lblServer.gridx = 1;
			gbc_lblServer.gridy = 0;
			contentPanel.add(lblServer, gbc_lblServer);
		}
		{
			JLabel lblPort = new JLabel("Command");
			GridBagConstraints gbc_lblPort = new GridBagConstraints();
			gbc_lblPort.insets = new Insets(0, 0, 5, 5);
			gbc_lblPort.anchor = GridBagConstraints.WEST;
			gbc_lblPort.gridx = 2;
			gbc_lblPort.gridy = 0;
			contentPanel.add(lblPort, gbc_lblPort);
		}
		{
			JLabel lblPrivateMessage = new JLabel("Private Message");
			GridBagConstraints gbc_lblPrivateMessage = new GridBagConstraints();
			gbc_lblPrivateMessage.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrivateMessage.anchor = GridBagConstraints.EAST;
			gbc_lblPrivateMessage.gridx = 1;
			gbc_lblPrivateMessage.gridy = 1;
			contentPanel.add(lblPrivateMessage, gbc_lblPrivateMessage);
		}
		{
			txtPort = new JTextField();
			txtPort.setEditable(false);
			txtPort.setText("/tell <USERNAME>");
			GridBagConstraints gbc_txtPort = new GridBagConstraints();
			gbc_txtPort.insets = new Insets(0, 0, 5, 5);
			gbc_txtPort.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPort.gridx = 2;
			gbc_txtPort.gridy = 1;
			contentPanel.add(txtPort, gbc_txtPort);
			txtPort.setColumns(10);
		}
		{
			JLabel lblUsername = new JLabel("Joining a room");
			GridBagConstraints gbc_lblUsername = new GridBagConstraints();
			gbc_lblUsername.anchor = GridBagConstraints.EAST;
			gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
			gbc_lblUsername.gridx = 1;
			gbc_lblUsername.gridy = 2;
			contentPanel.add(lblUsername, gbc_lblUsername);
		}
		{
			txtjoin = new JTextField();
			txtjoin.setText("/join <ROOM>");
			txtjoin.setEditable(false);
			txtjoin.setColumns(10);
			GridBagConstraints gbc_txtjoin = new GridBagConstraints();
			gbc_txtjoin.insets = new Insets(0, 0, 5, 5);
			gbc_txtjoin.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtjoin.gridx = 2;
			gbc_txtjoin.gridy = 2;
			contentPanel.add(txtjoin, gbc_txtjoin);
		}
		{
			JLabel lblCreatingARoom = new JLabel("Creating a room");
			GridBagConstraints gbc_lblCreatingARoom = new GridBagConstraints();
			gbc_lblCreatingARoom.anchor = GridBagConstraints.EAST;
			gbc_lblCreatingARoom.insets = new Insets(0, 0, 5, 5);
			gbc_lblCreatingARoom.gridx = 1;
			gbc_lblCreatingARoom.gridy = 3;
			contentPanel.add(lblCreatingARoom, gbc_lblCreatingARoom);
		}
		{
			txtjoin_1 = new JTextField();
			txtjoin_1.setText("/join <ROOM>");
			txtjoin_1.setEditable(false);
			txtjoin_1.setColumns(10);
			GridBagConstraints gbc_txtjoin_1 = new GridBagConstraints();
			gbc_txtjoin_1.insets = new Insets(0, 0, 5, 5);
			gbc_txtjoin_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtjoin_1.gridx = 2;
			gbc_txtjoin_1.gridy = 3;
			contentPanel.add(txtjoin_1, gbc_txtjoin_1);
		}
		{
			JLabel label = new JLabel("Joining a room");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.gridx = 1;
			gbc_label.gridy = 4;
			contentPanel.add(label, gbc_label);
		}
		{
			textField = new JTextField();
			textField.setText("/join <ROOM>");
			textField.setEditable(false);
			textField.setColumns(10);
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 4;
			contentPanel.add(textField, gbc_textField);
		}
		{
			JLabel lblReturnToMainlobby = new JLabel("Return to Mainlobby");
			GridBagConstraints gbc_lblReturnToMainlobby = new GridBagConstraints();
			gbc_lblReturnToMainlobby.anchor = GridBagConstraints.EAST;
			gbc_lblReturnToMainlobby.insets = new Insets(0, 0, 5, 5);
			gbc_lblReturnToMainlobby.gridx = 1;
			gbc_lblReturnToMainlobby.gridy = 5;
			contentPanel.add(lblReturnToMainlobby, gbc_lblReturnToMainlobby);
		}
		{
			txtleave = new JTextField();
			txtleave.setText("/leave");
			txtleave.setEditable(false);
			txtleave.setColumns(10);
			GridBagConstraints gbc_txtleave = new GridBagConstraints();
			gbc_txtleave.insets = new Insets(0, 0, 5, 5);
			gbc_txtleave.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtleave.gridx = 2;
			gbc_txtleave.gridy = 5;
			contentPanel.add(txtleave, gbc_txtleave);
		}
		{
			JLabel label = new JLabel("Server");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 6;
			contentPanel.add(label, gbc_label);
		}
		{
			textField_4 = new JTextField();
			textField_4.setText("Port");
			textField_4.setEditable(false);
			textField_4.setColumns(10);
			GridBagConstraints gbc_textField_4 = new GridBagConstraints();
			gbc_textField_4.insets = new Insets(0, 0, 5, 5);
			gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_4.gridx = 2;
			gbc_textField_4.gridy = 6;
			contentPanel.add(textField_4, gbc_textField_4);
		}
		{
			JLabel label = new JLabel("Server");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 7;
			contentPanel.add(label, gbc_label);
		}
		{
			textField_5 = new JTextField();
			textField_5.setText("Port");
			textField_5.setEditable(false);
			textField_5.setColumns(10);
			GridBagConstraints gbc_textField_5 = new GridBagConstraints();
			gbc_textField_5.insets = new Insets(0, 0, 5, 5);
			gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_5.gridx = 2;
			gbc_textField_5.gridy = 7;
			contentPanel.add(textField_5, gbc_textField_5);
		}
		{
			JLabel label = new JLabel("Server");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 8;
			contentPanel.add(label, gbc_label);
		}
		{
			textField_6 = new JTextField();
			textField_6.setText("Port");
			textField_6.setEditable(false);
			textField_6.setColumns(10);
			GridBagConstraints gbc_textField_6 = new GridBagConstraints();
			gbc_textField_6.insets = new Insets(0, 0, 5, 5);
			gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_6.gridx = 2;
			gbc_textField_6.gridy = 8;
			contentPanel.add(textField_6, gbc_textField_6);
		}
		{
			JLabel label = new JLabel("Server");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 9;
			contentPanel.add(label, gbc_label);
		}
		{
			textField_7 = new JTextField();
			textField_7.setText("Port");
			textField_7.setEditable(false);
			textField_7.setColumns(10);
			GridBagConstraints gbc_textField_7 = new GridBagConstraints();
			gbc_textField_7.insets = new Insets(0, 0, 5, 5);
			gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_7.gridx = 2;
			gbc_textField_7.gridy = 9;
			contentPanel.add(textField_7, gbc_textField_7);
		}
		{
			JLabel label = new JLabel("Server");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 10;
			contentPanel.add(label, gbc_label);
		}
		{
			textField_8 = new JTextField();
			textField_8.setText("Port");
			textField_8.setEditable(false);
			textField_8.setColumns(10);
			GridBagConstraints gbc_textField_8 = new GridBagConstraints();
			gbc_textField_8.insets = new Insets(0, 0, 5, 5);
			gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_8.gridx = 2;
			gbc_textField_8.gridy = 10;
			contentPanel.add(textField_8, gbc_textField_8);
		}
		{
			JLabel label = new JLabel("Server");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 11;
			contentPanel.add(label, gbc_label);
		}
		{
			textField_9 = new JTextField();
			textField_9.setText("Port");
			textField_9.setEditable(false);
			textField_9.setColumns(10);
			GridBagConstraints gbc_textField_9 = new GridBagConstraints();
			gbc_textField_9.insets = new Insets(0, 0, 5, 5);
			gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_9.gridx = 2;
			gbc_textField_9.gridy = 11;
			contentPanel.add(textField_9, gbc_textField_9);
		}
		{
			JLabel label = new JLabel("Server");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 12;
			contentPanel.add(label, gbc_label);
		}
		{
			textField_10 = new JTextField();
			textField_10.setText("Port");
			textField_10.setEditable(false);
			textField_10.setColumns(10);
			GridBagConstraints gbc_textField_10 = new GridBagConstraints();
			gbc_textField_10.insets = new Insets(0, 0, 5, 5);
			gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_10.gridx = 2;
			gbc_textField_10.gridy = 12;
			contentPanel.add(textField_10, gbc_textField_10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Thanks, Bro!");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		this.setModal(true);
		setVisible(true);
	}

}
