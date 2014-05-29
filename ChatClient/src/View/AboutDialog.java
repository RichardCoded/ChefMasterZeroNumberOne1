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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class AboutDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private MainFrame mainframe;
	public AboutDialog(MainFrame mainframe) {
		this.mainframe = mainframe;
		setUndecorated(true);
		setResizable(false);
		setTitle("About");
		setSize(339, 547);
		setLocationRelativeTo(mainframe);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "About", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 120, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblPic = new JLabel("");
			lblPic.setIcon(new ImageIcon(getClass().getResource("/resources/madaf.jpg")));
			GridBagConstraints gbc_lblPic = new GridBagConstraints();
			gbc_lblPic.gridwidth = 2;
			gbc_lblPic.insets = new Insets(0, 0, 5, 5);
			gbc_lblPic.gridx = 0;
			gbc_lblPic.gridy = 0;
			contentPanel.add(lblPic, gbc_lblPic);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Don't Push Me");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						AboutDialog.this.dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		
		setVisible(true);
	}

}
