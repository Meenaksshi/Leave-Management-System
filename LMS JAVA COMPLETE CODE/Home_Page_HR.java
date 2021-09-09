package LEAVE_MANAGEMENT_SYSTEM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home_Page_HR extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable leave_table = new JTable();
	private final JLabel lblNewLabel_1 = new JLabel("Dashboard HR Manager");
	private final JLabel lblCancelButton = new JLabel("X");
	private final JLabel lblMinimizeButton = new JLabel("-");
	private final JPanel panel = new JPanel();
	private final JLabel lblLeaveId = new JLabel("LEAVE ID :");
	private final JTextField textField = new JTextField();
	private final JLabel lblStatus = new JLabel("STATUS :");
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JLabel lblFeedback = new JLabel("FEEDBACK :");
	private final JButton btnSave = new JButton("SAVE");
	private final JPanel panel_1 = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void HR_PAGE() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Page_HR frame = new Home_Page_HR();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home_Page_HR() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 703, 382);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(20, 76, 662, 92);
		
		contentPane.add(scrollPane);
		String[] column= {"leave_id", "leave_type","start_date","end_date","reason","status","admin_feedback","date_of_feedback"};
		my_mysql2 obj=new my_mysql2();
		
		leave_table = new javax.swing.JTable(obj.my_db_select(),column);
		scrollPane.setViewportView(leave_table);
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		lblNewLabel_1.setBackground(new Color(245, 255, 250));
		lblNewLabel_1.setBounds(162, 10, 443, 46);
		
		contentPane.add(lblNewLabel_1);
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
		lblCancelButton.setBounds(668, 14, 25, 37);
		
		contentPane.add(lblCancelButton);
		lblMinimizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblMinimizeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimizeButton.setForeground(Color.BLACK);
		lblMinimizeButton.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
		lblMinimizeButton.setBackground(new Color(245, 255, 250));
		lblMinimizeButton.setBounds(633, 10, 25, 37);
		
		contentPane.add(lblMinimizeButton);
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(10, 10, 683, 46);
		
		contentPane.add(panel);
		lblLeaveId.setForeground(Color.WHITE);
		lblLeaveId.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		lblLeaveId.setBounds(29, 187, 106, 18);
		
		contentPane.add(lblLeaveId);
		textField.setFont(new Font("Stencil", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBackground(new Color(224, 255, 255));
		textField.setBounds(150, 182, 205, 37);
		
		contentPane.add(textField);
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		lblStatus.setBounds(29, 254, 106, 18);
		
		contentPane.add(lblStatus);
		textField_1.setFont(new Font("Stencil", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(224, 255, 255));
		textField_1.setBounds(150, 249, 205, 37);
		
		contentPane.add(textField_1);
		textField_2.setFont(new Font("Stencil", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(224, 255, 255));
		textField_2.setBounds(453, 221, 205, 64);
		
		contentPane.add(textField_2);
		lblFeedback.setForeground(Color.WHITE);
		lblFeedback.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 18));
		lblFeedback.setBounds(509, 187, 106, 18);
		
		contentPane.add(lblFeedback);
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//LEAVE APPROVAL
				String message = "";
				try
				{
				String JdbcURL = "jdbc:mysql://localhost:3306/lms";
			      String Username = "root";
			      String pass = "root123456";
				  String query = "Update leave_details \r\n"
				  		+ "	set Status = ?,\r\n"
				  		+ "		admin_feedback = ?,\r\n"
				  		+ "        date_of_feedback = ?\r\n"
				  		+ "	where leave_id = ?;";
					Connection con = DriverManager.getConnection(JdbcURL, Username, pass);
					System.out.println("Connected to MySQL database");
					PreparedStatement st = con.prepareStatement(query);
					String status = textField_1.getText();
					st.setString(1,status);
					 System.out.println(status);
					String feedback = textField_2.getText();
					st.setString(2, feedback);
					System.out.println(feedback);
					java.util.Date utilDate = new Date();
					java.sql.Date date = new java.sql.Date(utilDate.getTime());
					System.out.println(date);
					st.setDate(3,date);
					String r = textField.getText();
					st.setString(4,r);
					System.out.println(r);
					st.executeUpdate();
				    System.out.println("Values Inserted");
				    message = "Feedback sent";
				}catch(Exception e1){ System.out.println(e1);
			}
				JOptionPane.showMessageDialog(null, message);
					
			
			}
		});
		btnSave.setForeground(Color.BLUE);
		btnSave.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		btnSave.setBackground(Color.CYAN);
		btnSave.setBounds(283, 310, 134, 37);
		
		contentPane.add(btnSave);
		panel_1.setBackground(new Color(0, 0, 255));
		panel_1.setBounds(10, 66, 683, 306);
		
		contentPane.add(panel_1);
	}
}
class my_mysql2 {
int size = 4;
public  String[][] my_db_select() {
String[][] data = new String[size][8];
try{  
	String JdbcURL = "jdbc:mysql://localhost:3306/lms";
      String Username = "root";
      String pass = "root123456";
	  String query = "SELECT * FROM lms.leave_details WHERE status=\"Pending\";";
		Connection con = DriverManager.getConnection(JdbcURL, Username, pass);
		System.out.println("Connected to MySQL database");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		int i=0;
		while(rs.next())  
		{
			for(int j=0;j<8;j++) 
			{
				//System.out.print(rs.getString(j+1));
				data[i][j]=rs.getString(j+1);
			}
			//System.out.println();
			i=i+1;
		}  
	
 for (int x=0;x<data.length;x++) {
	 for (int y=0;(data[x]!= null && y <data[x].length);y++) {
		 System.out.print(data[x][y] + " ");
	 }
	 System.out.println();
 }

		st.close();
		con.close();
}catch(Exception e){ System.out.println(e);} 

return data;
	}
}
