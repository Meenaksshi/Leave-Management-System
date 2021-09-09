package LEAVE_MANAGEMENT_SYSTEM;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Login_table extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable login_db = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception
	{

		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					Login_table frame = new Login_table();
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
	public Login_table() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(10, 10, 416, 243);
		
		contentPane.add(scrollPane);
		String[] column= {"Login_id","Password","User_Type"};
		my_mysql obj=new my_mysql();

		login_db = new javax.swing.JTable(obj.my_db_select(),column);
		scrollPane.setViewportView(login_db);
	}
}

class my_mysql {
int size = 14;
public  String[][] my_db_select() {
String[][] data = new String[size][3];
try{  
	  String JdbcURL = "jdbc:mysql://localhost:3306/lms";
      String Username = "root";
      String pass = "root123456";
	  String query = "SELECT * FROM lms.login LIMIT 0,14;";
		Connection con = DriverManager.getConnection(JdbcURL, Username, pass);
		System.out.println("Connected to MySQL database");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		int i=0;
		while(rs.next())  
		{
			for(int j=0;j<3;j++) 
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
