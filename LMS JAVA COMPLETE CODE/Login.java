package LEAVE_MANAGEMENT_SYSTEM;
import java.sql.*;


import java.util.Enumeration;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;

public class Login extends Leave_History{

	private JFrame frmLoginPage;
	private final JButton btnLogin = new JButton("Login");
	protected final JTextField username = new JTextField();
	private final JLabel lblUserName = new JLabel("USERNAME");
	private final JLabel lblPassword = new JLabel("PASSWORD");
	private final JPasswordField passwordField = new JPasswordField();
	private final JRadioButton rdbtnHR_Manager = new JRadioButton("HR_MANAGER");
	private final JRadioButton rdbtnEmployee = new JRadioButton("EMPLOYEE");
	private final ButtonGroup user_type = new ButtonGroup();
	private final JRadioButton rdbtnAdmin = new JRadioButton("ADMIN");
	private final JLabel lblUserType = new JLabel("USER TYPE : ");
	
	/**
	 * Launch the application.
	 */
	String emp_id,user_type_value;
	private String emp_password;
	private final JLabel lblNewLabel_1 = new JLabel("Login Page  ");
	private final JLabel lblCancelButton = new JLabel("X");
	private final JLabel lblMinimizeButton = new JLabel("-");
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel = new JLabel("Forgot Password");
	private final JPanel panel_1 = new JPanel();
	String getPassword()
	{
		return emp_password;
	}
	void setPassword(String emp_password)
	{
		this.emp_password = emp_password;
	}
	void displayError()
	{
		
	}
	Boolean verifyCredentials()
	{
		return false;
	}
	public static void main(String[] args) throws Exception
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLoginPage.setLocationRelativeTo(null);
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Login ob = new Login();
		ob.setPassword(ob.passwordField.toString());
		//ob.emp_id = ob.username.toString();
		//System.out.println(ob.emp_id);
		/*String JdbcURL = "jdbc:mysql://localhost:3306/lms";
	      String Username = "root";
	      String pass = "";
		  String query = "SELECT password FROM lms.login WHERE Login_id = \"CB.EN.U4CSE19131\";";
	      try 
	      {
			Connection con = DriverManager.getConnection(JdbcURL, Username, pass);
			System.out.println("Connected to MySQL database");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String password1 = rs.getString("password");
			System.out.println(password1);
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      */
	}
	 public String getSelectedButtonText(ButtonGroup buttonGroup) {
	        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	                return button.getText();
	            }
	        }

	        return null;
	    }
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		username.setFont(new Font("Stencil", Font.PLAIN, 15));
		username.setBackground(new Color(224, 255, 255));
		username.setBounds(188, 184, 171, 19);
		username.setColumns(10);
		frmLoginPage = new JFrame();
		frmLoginPage.setUndecorated(true);
		frmLoginPage.setTitle("LOGIN PAGE");
		frmLoginPage.getContentPane().setBackground(new Color(0, 0, 0));
		frmLoginPage.setBounds(100, 100, 450, 314);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setForeground(new Color(0, 0, 255));
		btnLogin.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		btnLogin.setBackground(new Color(0, 255, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "";
				int flag = 0,pos=0;
				my_mysql obj=new my_mysql();
				String data[][] = obj.my_db_select();
				for(int i=0;i<14;i++)  
				{
					if(username.getText().equals(data[i][0]))
					{
						flag=1;
						pos=i;
						break;
					}
				}
				//System.out.println(getSelectedButtonText(user_type));
				if(flag==1 && getSelectedButtonText(user_type).equals(data[pos][2]) && data[pos][1].equals(new String(passwordField.getPassword())))
				{
					message = "Login Successful";
					if("EMPLOYEE".equals(data[pos][2]))
					{
						Employee home = new Employee(username.getText());
						home.Home_Frame(username.getText());
					}
					else if("HR_MANAGER".equals(data[pos][2]))
					{
						Home_Page_HR home = new Home_Page_HR();
						home.HR_PAGE();
					}
					else if("ADMIN".equals(data[pos][2]))
					{
						System_admin ad = new System_admin();
						ad.admin();
					}
				}
				else
					message = "Invalid username/password";
				JOptionPane.showMessageDialog(null, message);
				//lblUserName.setText(emp_id);*/
			}
		});
		btnLogin.setBounds(104, 266, 117, 27);
		
		frmLoginPage.getContentPane().add(btnLogin);
		
		frmLoginPage.getContentPane().add(username);
		lblUserName.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
		lblUserName.setForeground(new Color(255, 255, 255));
		lblUserName.setBounds(66, 184, 106, 19);
		
		frmLoginPage.getContentPane().add(lblUserName);
		lblPassword.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(66, 226, 112, 18);
		
		frmLoginPage.getContentPane().add(lblPassword);
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 20));
		passwordField.setBackground(new Color(224, 255, 255));
		passwordField.setBounds(188, 225, 171, 19);
		
		frmLoginPage.getContentPane().add(passwordField);
		user_type.add(rdbtnHR_Manager);
		rdbtnHR_Manager.setBackground(new Color(224, 255, 255));
		rdbtnHR_Manager.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		rdbtnHR_Manager.setBounds(188, 123, 171, 21);
		
		frmLoginPage.getContentPane().add(rdbtnHR_Manager);
		user_type.add(rdbtnEmployee);
		rdbtnEmployee.setBackground(new Color(224, 255, 255));
		rdbtnEmployee.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		rdbtnEmployee.setBounds(188, 146, 171, 21);
		
		frmLoginPage.getContentPane().add(rdbtnEmployee);
		user_type.add(rdbtnAdmin);
		rdbtnAdmin.setBackground(new Color(224, 255, 255));
		rdbtnAdmin.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		rdbtnAdmin.setBounds(188, 100, 171, 21);
		
		frmLoginPage.getContentPane().add(rdbtnAdmin);
		lblUserType.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
		lblUserType.setForeground(new Color(255, 255, 255));
		lblUserType.setBounds(66, 125, 111, 17);
		
		frmLoginPage.getContentPane().add(lblUserType);
		lblCancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblCancelButton.setForeground(new Color(0, 0, 0));
		lblCancelButton.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
		lblCancelButton.setBackground(new Color(0, 0, 0));
		lblCancelButton.setBounds(415, 10, 25, 37);
		
		frmLoginPage.getContentPane().add(lblCancelButton);
		lblMinimizeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmLoginPage.setState(JFrame.ICONIFIED);
			}
		});
		lblMinimizeButton.setForeground(new Color(0, 0, 0));
		lblMinimizeButton.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
		lblMinimizeButton.setBackground(new Color(245, 255, 250));
		lblMinimizeButton.setBounds(382, 10, 25, 37);
		
		frmLoginPage.getContentPane().add(lblMinimizeButton);
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(10, 10, 430, 56);
		
		frmLoginPage.getContentPane().add(panel);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(245, 255, 250));
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//forgot pass code
				Reset_Password set = new Reset_Password(username.getText());
				set.Reset_Page(username.getText());
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(249, 266, 176, 27);
		
		frmLoginPage.getContentPane().add(lblNewLabel);
		panel_1.setBackground(new Color(0, 0, 255));
		panel_1.setBounds(10, 76, 430, 228);
		
		frmLoginPage.getContentPane().add(panel_1);
	}
}
