package LEAVE_MANAGEMENT_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdateMailId {

	private JFrame frmUpdateMail;
	private JTextField textFieldEmpId;
	private JTextField textFieldNewMail;

	/**
	 * Launch the application.
	 */
	public static void update_mail() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateMailId window = new UpdateMailId();
					window.frmUpdateMail.setLocationRelativeTo(null);
					window.frmUpdateMail.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateMailId() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateMail = new JFrame();
		frmUpdateMail.getContentPane().setBackground(Color.BLACK);
		frmUpdateMail.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 10, 430, 51);
		frmUpdateMail.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Mail Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 273, 31);
		panel.add(lblNewLabel);
		
		JLabel lblMinimize = new JLabel("-");
		lblMinimize.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMinimize.setBounds(357, 19, 23, 13);
		panel.add(lblMinimize);
		lblMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmUpdateMail.setState(JFrame.ICONIFIED);
			}
		});
		
		JLabel lblClose = new JLabel("x");
		lblClose.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblClose.setBounds(397, 10, 23, 30);
		panel.add(lblClose);
		lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
				
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(10, 71, 430, 219);
		frmUpdateMail.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Employee ID");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(32, 34, 136, 25);
		panel_1.add(lblNewLabel_3);
		
		textFieldEmpId = new JTextField();
		textFieldEmpId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldEmpId.setBounds(213, 34, 186, 25);
		panel_1.add(textFieldEmpId);
		textFieldEmpId.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("New Mail Id");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(32, 101, 160, 25);
		panel_1.add(lblNewLabel_4);
		
		textFieldNewMail = new JTextField();
		textFieldNewMail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNewMail.setBounds(213, 101, 207, 25);
		panel_1.add(textFieldNewMail);
		textFieldNewMail.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(Color.CYAN);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSubmit.setBounds(269, 170, 116, 39);
		panel_1.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.CYAN);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancel.setBounds(32, 170, 116, 39);
		panel_1.add(btnCancel);
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		frmUpdateMail.setUndecorated(true);
		frmUpdateMail.setBounds(100, 100, 450, 300);
		frmUpdateMail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//update employee mail Id
				
				try
				{
				String JdbcURL = "jdbc:mysql://localhost:3306/lms";
			      String Username = "root";
			      String pass = "root123456";
				 
					Connection con = DriverManager.getConnection(JdbcURL, Username, pass);
					System.out.println("Connected to MySQL database");
					String query = "UPDATE lms.emp_mail set mail_id=? where emp_id=?;";
					PreparedStatement st = con.prepareStatement(query);
					String mail_id = textFieldNewMail.getText();
					st.setString(1,mail_id);
					String emp_id = textFieldEmpId.getText();
					st.setString(2,emp_id);
					st.executeUpdate();
					con.close();
				}catch(Exception e1){ System.out.println(e1);
			}
				JOptionPane.showMessageDialog(null,"Mail ID updated");
					
			}
		});
	}
}
