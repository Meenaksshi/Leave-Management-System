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

public class UpdateAddr {

	private JFrame frmUpdateAddr;
	private JTextField textFieldEmpId;
	private JTextField textFieldDoorNo;
	private JTextField textFieldStreetName;
	private JTextField textFieldPincode;

	/**
	 * Launch the application.
	 */
	public static void update_addr() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAddr window = new UpdateAddr();
					window.frmUpdateAddr.setLocationRelativeTo(null);
					window.frmUpdateAddr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateAddr() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateAddr = new JFrame();
		frmUpdateAddr.getContentPane().setBackground(Color.BLACK);
		frmUpdateAddr.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 10, 446, 49);
		frmUpdateAddr.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUpdateAdd = new JLabel("Update Address");
		lblUpdateAdd.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUpdateAdd.setBounds(10, 10, 251, 29);
		panel.add(lblUpdateAdd);
		
		JLabel lblMinimize = new JLabel("-");
		lblMinimize.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMinimize.setBounds(382, 18, 22, 13);
		panel.add(lblMinimize);
		lblMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmUpdateAddr.setState(JFrame.ICONIFIED);
			}
		});
		
		JLabel lblClose = new JLabel("x");
		lblClose.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblClose.setBounds(414, 10, 22, 29);
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
		panel_1.setBounds(10, 69, 446, 264);
		frmUpdateAddr.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEmpId = new JLabel("Employee ID");
		lblEmpId.setForeground(Color.WHITE);
		lblEmpId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmpId.setBounds(10, 22, 136, 25);
		panel_1.add(lblEmpId);
		
		JLabel lblDoorNo = new JLabel("Door No");
		lblDoorNo.setForeground(Color.WHITE);
		lblDoorNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDoorNo.setBounds(10, 70, 88, 25);
		panel_1.add(lblDoorNo);
		
		JLabel lblStreetName = new JLabel("Street Name");
		lblStreetName.setForeground(Color.WHITE);
		lblStreetName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStreetName.setBounds(10, 115, 136, 25);
		panel_1.add(lblStreetName);
		
		JLabel lblPincode = new JLabel("Pincode");
		lblPincode.setForeground(Color.WHITE);
		lblPincode.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPincode.setBounds(10, 163, 88, 25);
		panel_1.add(lblPincode);
		
		textFieldEmpId = new JTextField();
		textFieldEmpId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldEmpId.setBounds(180, 22, 145, 25);
		panel_1.add(textFieldEmpId);
		textFieldEmpId.setColumns(10);
		
		textFieldDoorNo = new JTextField();
		textFieldDoorNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDoorNo.setBounds(178, 70, 147, 26);
		panel_1.add(textFieldDoorNo);
		textFieldDoorNo.setColumns(10);
		
		textFieldStreetName = new JTextField();
		textFieldStreetName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldStreetName.setBounds(180, 115, 240, 26);
		panel_1.add(textFieldStreetName);
		textFieldStreetName.setColumns(10);
		
		textFieldPincode = new JTextField();
		textFieldPincode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldPincode.setBounds(180, 163, 152, 26);
		panel_1.add(textFieldPincode);
		textFieldPincode.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancel.setBackground(Color.CYAN);
		btnCancel.setBounds(61, 216, 111, 38);
		panel_1.add(btnCancel);
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSubmit.setBackground(Color.CYAN);
		btnSubmit.setBounds(282, 216, 111, 38);
		panel_1.add(btnSubmit);
		frmUpdateAddr.setUndecorated(true);
		frmUpdateAddr.setBounds(100, 100, 466, 343);
		frmUpdateAddr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//update employee address
				
				try
				{
				String JdbcURL = "jdbc:mysql://localhost:3306/lms";
			      String Username = "root";
			      String pass = "root123456";
				 
					Connection con = DriverManager.getConnection(JdbcURL, Username, pass);
					System.out.println("Connected to MySQL database");
					String query = "UPDATE lms.employee set door_no=?,street_name=?,pincode=? where emp_id=?;";
					PreparedStatement st = con.prepareStatement(query);
					
					int door_no = Integer.parseInt(textFieldDoorNo.getText());
					st.setInt(1,door_no);
					String street_name = textFieldStreetName.getText();
					st.setString(2,street_name);
					int pincode = Integer.parseInt(textFieldPincode.getText());
					st.setInt(3,pincode);
					String emp_id = textFieldEmpId.getText();
					st.setString(4,emp_id);
					st.executeUpdate();
					con.close();
				}catch(Exception e1){ System.out.println(e1);
			}
				JOptionPane.showMessageDialog(null,"Address updated");
					
			}
		});
	}
}
