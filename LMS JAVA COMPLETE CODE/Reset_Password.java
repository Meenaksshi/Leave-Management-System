package LEAVE_MANAGEMENT_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Reset_Password {

	private JFrame frame;
	private final JLabel lblNewPassword = new JLabel("NEW PASSWORD : ");
	private final JLabel lblRetypePassword = new JLabel("RETYPE PASSWORD : ");
	private final JPasswordField passwordField = new JPasswordField();
	private final JPasswordField passwordField_1 = new JPasswordField();
	private final JButton btnSave = new JButton("SAVE");
	private final JLabel lblResetPassword = new JLabel("Reset Password  ");
	private final JLabel lblCancelButton = new JLabel("X");
	private final JLabel lblMinimizeButton = new JLabel("-");
	private final JPanel panel = new JPanel();
	private final JLabel lblUsername = new JLabel();
	private final JButton btnNewButton = new JButton("New button");
	private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void Reset_Page(String uname) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reset_Password window = new Reset_Password(uname);
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reset_Password(String uname) {
		initialize(uname);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String uname) {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblNewPassword.setForeground(new Color(255, 255, 255));
		lblNewPassword.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		lblNewPassword.setBounds(26, 131, 179, 25);
		
		frame.getContentPane().add(lblNewPassword);
		lblRetypePassword.setForeground(new Color(255, 255, 255));
		lblRetypePassword.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		lblRetypePassword.setBounds(26, 188, 230, 25);
		
		frame.getContentPane().add(lblRetypePassword);
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 20));
		passwordField.setBackground(new Color(224, 255, 255));
		passwordField.setBounds(223, 131, 193, 25);
		
		frame.getContentPane().add(passwordField);
		passwordField_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		passwordField_1.setBackground(new Color(224, 255, 255));
		passwordField_1.setBounds(223, 188, 193, 25);
		
		frame.getContentPane().add(passwordField_1);
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check validity
				String message = "";
				if((new String(passwordField.getPassword())).equals(new String(passwordField_1.getPassword())))
				{
					message = "Password Changed";
					try
					{
					String JdbcURL = "jdbc:mysql://localhost:3306/lms";
				      String Username = "root";
				      String pass = "root123456";
				      String new_password = (new String(passwordField.getPassword()));
					  String query = "Update login set Password = ? where login_id =?;";
						Connection con = DriverManager.getConnection(JdbcURL, Username, pass);
						System.out.println("Connected to MySQL database");
						PreparedStatement st = con.prepareStatement(query);
						st.setString(1, new_password);
						st.setString(2, uname);
						st.executeUpdate();
					    System.out.println("Database updated successfully ");
					}catch(Exception e1){ System.out.println(e1);} 
				}
				else
					message = "Passwords doesn't match";
				JOptionPane.showMessageDialog(null, message);
			}
		});
		btnSave.setForeground(Color.BLUE);
		btnSave.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		btnSave.setBackground(Color.CYAN);
		btnSave.setBounds(143, 243, 117, 27);
		
		frame.getContentPane().add(btnSave);
		lblResetPassword.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		lblResetPassword.setBackground(new Color(245, 255, 250));
		lblResetPassword.setBounds(49, 10, 263, 46);
		
		frame.getContentPane().add(lblResetPassword);
		lblCancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblCancelButton.setForeground(Color.BLACK);
		lblCancelButton.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
		lblCancelButton.setBackground(Color.BLACK);
		lblCancelButton.setBounds(391, 14, 25, 36);
		
		frame.getContentPane().add(lblCancelButton);
		lblMinimizeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		lblMinimizeButton.setForeground(Color.BLACK);
		lblMinimizeButton.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
		lblMinimizeButton.setBackground(new Color(245, 255, 250));
		lblMinimizeButton.setBounds(356, 10, 25, 37);
		
		frame.getContentPane().add(lblMinimizeButton);
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(10, 10, 430, 46);
		
		frame.getContentPane().add(panel);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Stencil", Font.BOLD, 25));
		lblUsername.setBackground(SystemColor.menu);
		lblUsername.setBounds(88, 66, 267, 45);
		
		frame.getContentPane().add(lblUsername);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUsername.setText(uname);
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setBounds(20, 75, 43, 36);
		
		frame.getContentPane().add(btnNewButton);
		panel_1.setBackground(new Color(0, 0, 255));
		panel_1.setBounds(10, 66, 430, 224);
		
		frame.getContentPane().add(panel_1);
	}
}
