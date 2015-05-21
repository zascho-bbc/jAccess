package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import validator.Validator;
import view.AdminView;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setResizable(false);
		setTitle("jAccess - Admin Login");
		setBounds(100, 100, 271, 205);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		{
			JLabel lblJaccessAdminLogin = new JLabel("jAccess Admin Login");
			lblJaccessAdminLogin.setBounds(10, 11, 172, 25);
			contentPanel.add(lblJaccessAdminLogin);
		}
		{
			textField = new JTextField();
			textField.setBounds(95, 62, 165, 28);
			contentPanel.add(textField);
			textField.setColumns(10);
		}

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 69, 66, 16);
		contentPanel.add(lblUsername);

		passwordField = new JPasswordField();
		passwordField.setBounds(95, 102, 165, 28);
		contentPanel.add(passwordField);

		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(10, 108, 66, 16);
		contentPanel.add(lblPasswort);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Remote remote = Naming.lookup("//localhost/Validator");
							Validator validator = (Validator) remote;
							String id = lblUsername.getText();
							String pw = lblPasswort.getText();
							if(validator.validate(id, pw)) {
								AdminView frame = new AdminView();
								frame.setVisible(true);
							}
						} catch (MalformedURLException | RemoteException | NotBoundException e1) {
							JOptionPane.showMessageDialog(null, "Probleme mit dem Login-Server! \nBitte wenden " + "Sie sich an den IT-Support.", "Fehler", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);						
					}
					
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
