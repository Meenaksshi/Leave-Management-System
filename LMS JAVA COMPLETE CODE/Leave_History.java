package LEAVE_MANAGEMENT_SYSTEM;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Cursor;

public class Leave_History extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable leave_table = new JTable();
	private final JLabel lblNewLabel_1 = new JLabel("Leave History");
	private final JLabel lblCancelButton = new JLabel("X");
	private final JLabel lblMinimizeButton = new JLabel("-");
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void Leave() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leave_History frame = new Leave_History();
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
	public Leave_History() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 703, 311);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(10, 66, 683, 235);
		
		contentPane.add(scrollPane);
		String[] column= {"leave_id", "leave_type","start_date","end_date","reason","status","admin_feedback","date_of_feedback"};
		my_mysql1 obj=new my_mysql1();
		
		leave_table = new javax.swing.JTable(obj.my_db_select(),column);
		leave_table.setBackground(new Color(230, 230, 250));
		leave_table.setForeground(Color.BLUE);
		scrollPane.setViewportView(leave_table);
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		lblNewLabel_1.setBackground(new Color(245, 255, 250));
		lblNewLabel_1.setBounds(162, 10, 226, 46);
		
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
	}
}

class my_mysql1 {
int size = 12;
public  String[][] my_db_select() {
String[][] data = new String[size][8];
try{  
	String JdbcURL = "jdbc:mysql://localhost:3306/lms";
      String Username = "root";
      String pass = "root123456";
	  String query = "SELECT * FROM lms.leave_details LIMIT 0,12;";
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

