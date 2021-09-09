package LEAVE_MANAGEMENT_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.Panel;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.Cursor;

public class Apply_Leave {

	int i=8;
	private JFrame frame;
	private final JLabel lblNewLabel = new JLabel("Leave Type ");
	private final JComboBox Leave_Type = new JComboBox();
	private final JLabel lblNoofdays = new JLabel("No of days");
	private final JSlider slider = new JSlider();
	private final JLabel lblStartdate = new JLabel("Start date");
	private final JDateChooser dateChooser = new JDateChooser();
	private final JLabel lblEnddate = new JLabel("End date");
	private final JDateChooser dateChooser_1 = new JDateChooser();
	private final JLabel lblReason = new JLabel("Reason");
	private final JTextField textField = new JTextField();
	private final JButton btnCancel = new JButton("CANCEL");
	private final JButton btnSubmit = new JButton("SUBMIT");
	private final JLabel lblNewLabel_1 = new JLabel("Enter Leave Details  ");
	private final JLabel lblCancelButton = new JLabel("X");
	private final JLabel lblMinimizeButton = new JLabel("-");
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void Enter_Leave_Details() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apply_Leave window = new Apply_Leave();
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
	public Apply_Leave() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		textField.setBounds(141, 208, 266, 26);
		textField.setColumns(10);
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 452, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(28, 67, 103, 26);
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		
		frame.getContentPane().add(lblNewLabel);
		Leave_Type.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Leave_Type.setBounds(141, 66, 266, 26);
		Leave_Type.setFont(new Font("Segoe Print", Font.BOLD, 15));
		Leave_Type.setModel(new DefaultComboBoxModel(new String[] {"Earned leave", "Casual leave", "Medical leave", "Half-pay leave", "Maternity leave", "Marriage leave", "Vacation leave", "Sabbatical leave", "Lockdown leave"}));
		
		frame.getContentPane().add(Leave_Type);
		lblNoofdays.setForeground(new Color(255, 255, 255));
		lblNoofdays.setBounds(28, 103, 103, 21);
		lblNoofdays.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		
		frame.getContentPane().add(lblNoofdays);
		slider.setValue(1);
		slider.setMaximum(10);
		slider.setMinimum(1);
		slider.setBounds(141, 102, 266, 21);
		
		frame.getContentPane().add(slider);
		lblStartdate.setForeground(new Color(255, 255, 255));
		lblStartdate.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		lblStartdate.setBounds(28, 136, 103, 26);
		
		frame.getContentPane().add(lblStartdate);
		dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser.setBounds(141, 136, 266, 26);
		
		frame.getContentPane().add(dateChooser);
		lblEnddate.setForeground(new Color(255, 255, 255));
		lblEnddate.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		lblEnddate.setBounds(28, 172, 103, 26);
		
		frame.getContentPane().add(lblEnddate);
		dateChooser_1.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser_1.setBounds(141, 172, 266, 26);
		
		frame.getContentPane().add(dateChooser_1);
		lblReason.setForeground(new Color(255, 255, 255));
		lblReason.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
		lblReason.setBounds(28, 206, 103, 26);
		
		frame.getContentPane().add(lblReason);
		
		frame.getContentPane().add(textField);
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setForeground(Color.BLUE);
		btnCancel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		btnCancel.setBackground(Color.CYAN);
		btnCancel.setBounds(50, 259, 163, 46);
		
		frame.getContentPane().add(btnCancel);
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//apply leave code
				String message = "";
				try
				{
				String JdbcURL = "jdbc:mysql://localhost:3306/lms";
			      String Username = "root";
			      String pass = "root123456";
				  String query = "INSERT INTO Leave_details(leave_id, leave_type,start_date,end_date,reason) values(?, ?, ?, ?, ?);";
					Connection con = DriverManager.getConnection(JdbcURL, Username, pass);
					System.out.println("Connected to MySQL database");
					PreparedStatement st = con.prepareStatement(query);
					st.setString(1, "LVE09");
					String type = Leave_Type.getSelectedItem().toString();
					st.setString(2,type);
					 System.out.println(type);
					 java.util.Date myDate = new java.util.Date();
					 java.sql.Date sqlDate = new java.sql.Date(dateChooser.getDate().getTime());
					st.setDate(3, sqlDate);
					 System.out.println(sqlDate);
					 java.sql.Date sqlDate1 = new java.sql.Date(dateChooser_1.getDate().getTime());
					st.setDate(4, sqlDate1);
					System.out.println(sqlDate1);
					String r = textField.getText();
					st.setString(5,r);
					System.out.println(r);
					st.executeUpdate();
				    System.out.println("Values Inserted");
				    message = "Leave request sent!!";
				}catch(Exception e1){ System.out.println(e1);
			}
				JOptionPane.showMessageDialog(null, message);
					
			}
		});
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		btnSubmit.setBackground(Color.CYAN);
		btnSubmit.setBounds(265, 259, 158, 46);
		
		frame.getContentPane().add(btnSubmit);
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		lblNewLabel_1.setBackground(new Color(245, 255, 250));
		lblNewLabel_1.setBounds(28, 11, 341, 46);
		
		frame.getContentPane().add(lblNewLabel_1);
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
		lblCancelButton.setBounds(398, 15, 25, 37);
		
		frame.getContentPane().add(lblCancelButton);
		lblMinimizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		lblMinimizeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimizeButton.setForeground(Color.BLACK);
		lblMinimizeButton.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
		lblMinimizeButton.setBackground(new Color(245, 255, 250));
		lblMinimizeButton.setBounds(364, 11, 25, 37);
		
		frame.getContentPane().add(lblMinimizeButton);
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(10, 10, 430, 47);
		
		frame.getContentPane().add(panel);
		panel_1.setBackground(new Color(0, 0, 255));
		panel_1.setBounds(8, 67, 432, 253);
		
		frame.getContentPane().add(panel_1);
	}
}
