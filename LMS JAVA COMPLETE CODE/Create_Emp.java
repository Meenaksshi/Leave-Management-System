package LEAVE_MANAGEMENT_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Enumeration;

import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Create_Emp extends JFrame{

	private JFrame frmCreateEmp;
	private JTextField textFieldEmpId;
	private JTextField textFieldFirstName;
	private JTextField textFieldMiddleName;
	private JTextField textFieldLastName;
	private JTextField textFieldMaritalStatus;
	private JTextField textFieldPayrollId;
	private JTextField textFieldJobCode;
	private JTextField textFieldDeptCode;
	private JTextField textFieldDesg;
	private JTextField textFieldLoginId;
	private JTextField textFieldDoorNo;
	private JTextField textFieldStreetName;
	private JTextField textFieldPincode;
	private ButtonGroup genderselect = new ButtonGroup();
	private JTextField textFieldDeptName;

	/**
	 * Launch the application.
	 */
	public void create_emp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_Emp window = new Create_Emp();
					window.frmCreateEmp.setLocationRelativeTo(null);
					window.frmCreateEmp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	public Create_Emp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreateEmp = new JFrame();
		frmCreateEmp.getContentPane().setBackground(Color.BLACK);
		frmCreateEmp.setForeground(Color.BLACK);
		frmCreateEmp.setBackground(Color.BLACK);
		frmCreateEmp.setUndecorated(true);
		frmCreateEmp.setBounds(100, 100, 778, 558);
		frmCreateEmp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateEmp.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 758, 57);
		panel.setBackground(Color.CYAN);
		frmCreateEmp.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCreateEmp = new JLabel("Create Employee Record");
		lblCreateEmp.setFont(new Font("Dialog", Font.BOLD, 40));
		lblCreateEmp.setBounds(33, 10, 535, 37);
		panel.add(lblCreateEmp);
		
		JLabel lblMinimize = new JLabel("-");
		lblMinimize.setFont(new Font("Dialog", Font.BOLD, 40));
		lblMinimize.setBounds(656, 22, 45, 13);
		panel.add(lblMinimize);
		lblMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmCreateEmp.setState(JFrame.ICONIFIED);
			}
		});
		
		
		JLabel lblClose = new JLabel("x");
		lblClose.setFont(new Font("Dialog", Font.BOLD, 40));
		lblClose.setBounds(703, 10, 45, 37);
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
		panel_1.setBounds(10, 77, 758, 471);
		frmCreateEmp.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEmpId = new JLabel("Emp id");
		lblEmpId.setForeground(Color.WHITE);
		lblEmpId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmpId.setBounds(36, 10, 79, 30);
		panel_1.add(lblEmpId);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFirstName.setBounds(36, 50, 125, 25);
		panel_1.add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setForeground(Color.WHITE);
		lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMiddleName.setBounds(36, 85, 137, 30);
		panel_1.add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLastName.setBounds(36, 125, 114, 30);
		panel_1.add(lblLastName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(36, 165, 103, 30);
		panel_1.add(lblGender);
		
		JLabel lblDOB = new JLabel("DOB");
		lblDOB.setForeground(Color.WHITE);
		lblDOB.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDOB.setBounds(36, 205, 66, 30);
		panel_1.add(lblDOB);
		
		JLabel lblMaritalStatus = new JLabel("Marital Status");
		lblMaritalStatus.setForeground(Color.WHITE);
		lblMaritalStatus.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMaritalStatus.setBounds(36, 238, 158, 25);
		panel_1.add(lblMaritalStatus);
		
		textFieldEmpId = new JTextField();
		textFieldEmpId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldEmpId.setBounds(207, 10, 193, 25);
		panel_1.add(textFieldEmpId);
		textFieldEmpId.setColumns(10);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldFirstName.setBounds(207, 50, 193, 26);
		panel_1.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldMiddleName = new JTextField();
		textFieldMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldMiddleName.setBounds(207, 86, 193, 29);
		panel_1.add(textFieldMiddleName);
		textFieldMiddleName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldLastName.setBounds(207, 125, 193, 29);
		panel_1.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		JDateChooser dateChooserDOB = new JDateChooser();
		dateChooserDOB.setBounds(207, 205, 193, 19);
		panel_1.add(dateChooserDOB);
		
		textFieldMaritalStatus = new JTextField();
		textFieldMaritalStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldMaritalStatus.setBounds(204, 245, 52, 19);
		panel_1.add(textFieldMaritalStatus);
		textFieldMaritalStatus.setColumns(10);
		
		JLabel lblYN = new JLabel("Enter 'Y' for married or 'N' for unmarried");
		lblYN.setForeground(Color.WHITE);
		lblYN.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblYN.setBounds(267, 244, 211, 21);
		panel_1.add(lblYN);
		
		JLabel lblPayrollId = new JLabel("Payroll id");
		lblPayrollId.setForeground(Color.WHITE);
		lblPayrollId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPayrollId.setBounds(458, 10, 103, 26);
		panel_1.add(lblPayrollId);
		
		textFieldPayrollId = new JTextField();
		textFieldPayrollId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldPayrollId.setBounds(574, 10, 174, 21);
		panel_1.add(textFieldPayrollId);
		textFieldPayrollId.setColumns(10);
		
		JLabel lblJobCode = new JLabel("Job code");
		lblJobCode.setForeground(Color.WHITE);
		lblJobCode.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblJobCode.setBounds(458, 50, 103, 23);
		panel_1.add(lblJobCode);
		
		textFieldJobCode = new JTextField();
		textFieldJobCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldJobCode.setBounds(574, 50, 174, 21);
		panel_1.add(textFieldJobCode);
		textFieldJobCode.setColumns(10);
		
		JLabel lblDeptCode = new JLabel("Dept code");
		lblDeptCode.setForeground(Color.WHITE);
		lblDeptCode.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDeptCode.setBounds(458, 85, 103, 25);
		panel_1.add(lblDeptCode);
		
		textFieldDeptCode = new JTextField();
		textFieldDeptCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDeptCode.setBounds(574, 85, 174, 25);
		panel_1.add(textFieldDeptCode);
		textFieldDeptCode.setColumns(10);
		
		JLabel lblDesg = new JLabel("Designation");
		lblDesg.setForeground(Color.WHITE);
		lblDesg.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDesg.setBounds(458, 125, 125, 26);
		panel_1.add(lblDesg);
		
		textFieldDesg = new JTextField();
		textFieldDesg.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDesg.setBounds(584, 125, 164, 25);
		panel_1.add(textFieldDesg);
		textFieldDesg.setColumns(10);
		
		JLabel lblLoginId = new JLabel("Login id");
		lblLoginId.setForeground(Color.WHITE);
		lblLoginId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginId.setBounds(458, 165, 103, 26);
		panel_1.add(lblLoginId);
		
		textFieldLoginId = new JTextField();
		textFieldLoginId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldLoginId.setBounds(574, 165, 174, 25);
		panel_1.add(textFieldLoginId);
		textFieldLoginId.setColumns(10);
		
		JLabel lblAddr = new JLabel("Address:");
		lblAddr.setForeground(Color.WHITE);
		lblAddr.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddr.setBounds(36, 279, 125, 28);
		panel_1.add(lblAddr);
		
		JLabel lblDoorNo = new JLabel("Door No");
		lblDoorNo.setForeground(Color.WHITE);
		lblDoorNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDoorNo.setBounds(36, 317, 88, 21);
		panel_1.add(lblDoorNo);
		
		textFieldDoorNo = new JTextField();
		textFieldDoorNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDoorNo.setBounds(134, 317, 96, 24);
		panel_1.add(textFieldDoorNo);
		textFieldDoorNo.setColumns(10);
		
		JLabel lblStreetName = new JLabel("Street Name");
		lblStreetName.setForeground(Color.WHITE);
		lblStreetName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStreetName.setBounds(330, 317, 131, 21);
		panel_1.add(lblStreetName);
		
		textFieldStreetName = new JTextField();
		textFieldStreetName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldStreetName.setBounds(471, 317, 277, 21);
		panel_1.add(textFieldStreetName);
		textFieldStreetName.setColumns(10);
		
		JLabel lblPincode = new JLabel("Pincode");
		lblPincode.setForeground(Color.WHITE);
		lblPincode.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPincode.setBounds(36, 363, 79, 25);
		panel_1.add(lblPincode);
		
		textFieldPincode = new JTextField();
		textFieldPincode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldPincode.setBounds(134, 363, 137, 26);
		panel_1.add(textFieldPincode);
		textFieldPincode.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.CYAN);
		btnCancel.setBounds(200, 421, 110, 30);
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
		btnSubmit.setBounds(471, 421, 112, 30);
		panel_1.add(btnSubmit);
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JRadioButton rdbtnMale = new JRadioButton("M");
		rdbtnMale.setBounds(213, 170, 43, 21);
		panel_1.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnMale.setBackground(Color.CYAN);
		genderselect.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("F");
		rdbtnFemale.setBounds(283, 170, 43, 21);
		panel_1.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnFemale.setBackground(Color.CYAN);
		genderselect.add(rdbtnFemale);
		
		JLabel lblDeptName = new JLabel("Dept Name");
		lblDeptName.setForeground(Color.WHITE);
		lblDeptName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDeptName.setBounds(458, 205, 125, 19);
		panel_1.add(lblDeptName);
		
		textFieldDeptName = new JTextField();
		textFieldDeptName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDeptName.setBounds(584, 205, 164, 19);
		panel_1.add(textFieldDeptName);
		textFieldDeptName.setColumns(10);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create new employee record
				String message = "";
				try
				{ 
				String JdbcURL = "jdbc:mysql://localhost:3306/lms";
			      String Username = "root";
			      String pass = "root123456";
				  String query = "INSERT INTO lms.employee(emp_id,first_name,middle_name,last_name,gender,job_code,dob,door_no,street_name,marital_status,no_of_days_worked,dept_code,pincode,payroll_id,dept_name,designation,login_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
					Connection con = DriverManager.getConnection(JdbcURL, Username, pass);
					System.out.println("Connected to MySQL database");
					PreparedStatement st = con.prepareStatement(query);
					String emp_id = textFieldEmpId.getText();
					st.setString(1,emp_id);
					String first_name = textFieldFirstName.getText();
					st.setString(2,first_name);
					String middle_name = textFieldMiddleName.getText();
					st.setString(3,middle_name);
					String last_name = textFieldLastName.getText();
					st.setString(4,last_name);
					String gender="";
					if(rdbtnMale.isSelected())
						gender="M";
					else
						gender="F";
					st.setString(5,gender);
					String job_code = textFieldJobCode.getText();
					st.setString(6,job_code);
					java.util.Date myDate = new java.util.Date();
					java.sql.Date dob = new java.sql.Date(dateChooserDOB.getDate().getTime());
					st.setDate(7, dob);
					System.out.println(dob);
					int door_no = Integer.parseInt(textFieldDoorNo.getText());
					st.setInt(8,door_no);
					String street_name = textFieldStreetName.getText();
					st.setString(9,street_name);
					String marital_status = textFieldMaritalStatus.getText();
					st.setString(10,marital_status);
					int no_of_days_worked=0;
					st.setInt(11,no_of_days_worked);
					String dept_code = textFieldDeptCode.getText();
					st.setString(12,dept_code);
					int pincode = Integer.parseInt(textFieldPincode.getText());
					st.setInt(13,pincode);
					String payroll_id = textFieldPayrollId.getText();
					st.setString(14,payroll_id);
					String dept_name = textFieldDeptName.getText();
					st.setString(15,dept_name);
					String desg = textFieldDesg.getText();
					st.setString(16,desg);
					String login_id = textFieldLoginId.getText();
					st.setString(17,login_id);
					st.executeUpdate();
					con.close();
				}catch(Exception e1){ System.out.println(e1);
			}
				JOptionPane.showMessageDialog(null,"New Employee Record Created");	
			}
		});
	}
}
