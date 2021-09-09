package LEAVE_MANAGEMENT_SYSTEM;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Cursor;

public class Employee extends Login{
	
	private JFrame frame;
	private final JButton btnUpdateProfile = new JButton("Update Profile");
	private final JButton btnApplyLeave = new JButton("Apply leave");
	private final JButton btnViewLeaveHistory = new JButton("View leave History");
	private final JLabel lblDashboard = new JLabel("Dashboard  ");
	private final JLabel lblCancelButton = new JLabel("X");
	private final JLabel lblMinimizeButton = new JLabel("-");
	private final JPanel panel = new JPanel();
	private final JLabel lblUsername = new JLabel();
	private final JButton btnNewButton = new JButton("New button");
	private final JPanel panel_1 = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void Home_Frame(String u_name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee(u_name);
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
	public Employee(String u_name) {
		initialize(u_name);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String u_name) {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		btnUpdateProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reset_Password set = new Reset_Password(u_name);
				set.Reset_Page(u_name);
			}
		});
		btnUpdateProfile.setBackground(new Color(0, 255, 255));
		btnUpdateProfile.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnUpdateProfile.setBounds(100, 151, 230, 45);
		
		frame.getContentPane().add(btnUpdateProfile);
		btnApplyLeave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnApplyLeave.setBackground(new Color(0, 255, 255));
		btnApplyLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "";
				int leaves_taken=5;
					try
					{
					String JdbcURL = "jdbc:mysql://localhost:3306/lms";
				      String Username = "root";
				      String pass = "root123456";
					  String query = "SELECT leaves_taken FROM leave_history \r\n"
					  		+ "where emp_id IN\r\n"
					  		+ "				(SELECT emp_id\r\n"
					  		+ "                FROM EMPLOYEE \r\n"
					  		+ "                WHERE login_id = ?);";
						Connection con = DriverManager.getConnection(JdbcURL, Username, pass);
						System.out.println("Connected to MySQL database");
						PreparedStatement st = con.prepareStatement(query);
						st.setString(1, u_name);
						ResultSet rs = st.executeQuery();
						rs.next();
						leaves_taken=rs.getInt("leaves_taken");
					    System.out.println(leaves_taken);
					}catch(Exception e1){ System.out.println(e1);
				}
				if(leaves_taken<5)
				{
					message = "No. of Leaves taken : "+ leaves_taken+" \n You can apply "+(5-leaves_taken)+" more leaves for this month";
					Apply_Leave set = new Apply_Leave();
					set.Enter_Leave_Details();
				}
				else
					message = "No. of Leaves taken : "+ leaves_taken+" \n You don't have any leave balance in your account. \n No more leaves permitted for this month";
				JOptionPane.showMessageDialog(null, message);
				
			}
		});
		btnApplyLeave.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnApplyLeave.setBounds(100, 206, 230, 45);
		
		frame.getContentPane().add(btnApplyLeave);
		btnViewLeaveHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnViewLeaveHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Leave_History set = new Leave_History();
				set.Leave();
				
			}
		});
		btnViewLeaveHistory.setBackground(new Color(0, 255, 255));
		btnViewLeaveHistory.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnViewLeaveHistory.setBounds(100, 261, 230, 45);
		
		frame.getContentPane().add(btnViewLeaveHistory);
		lblDashboard.setBounds(122, 21, 183, 46);
		frame.getContentPane().add(lblDashboard);
		lblDashboard.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		lblDashboard.setBackground(new Color(245, 255, 250));
		lblCancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblCancelButton.setBounds(401, 25, 25, 36);
		frame.getContentPane().add(lblCancelButton);
		lblCancelButton.setForeground(Color.BLACK);
		lblCancelButton.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
		lblCancelButton.setBackground(Color.BLACK);
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
		lblMinimizeButton.setBounds(366, 25, 25, 37);
		
		frame.getContentPane().add(lblMinimizeButton);
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(10, 10, 430, 60);
		
		frame.getContentPane().add(panel);
		lblUsername.setBackground(new Color(240, 240, 240));
		lblUsername.setFont(new Font("Stencil", Font.BOLD, 25));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(100, 91, 267, 45);
		frame.getContentPane().add(lblUsername);
		btnNewButton.setBackground(new Color(0, 0, 205));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUsername.setText(u_name);
			}
		});
		btnNewButton.setBounds(20, 80, 25, 36);
		
		frame.getContentPane().add(btnNewButton);
		panel_1.setBackground(new Color(0, 0, 255));
		panel_1.setBounds(10, 80, 430, 244);
		
		frame.getContentPane().add(panel_1);
	}
}

