package LEAVE_MANAGEMENT_SYSTEM;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table_view {

private JFrame frame;
private JTable table;

/**
* Launch the application.
*/
public void disp() {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Table_view window = new Table_view();
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
public Table_view() {
initialize();
}

/**
* Initialize the contents of the frame.
*/
private void initialize() {
frame = new JFrame();
frame.getContentPane().setBackground(Color.BLACK);
frame.setBounds(100, 100, 1525, 135);
frame.setUndecorated(true);
frame.getContentPane().setLayout(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);

JLabel lblminimize = new JLabel("-");
lblminimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
lblminimize.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
frame.setState(JFrame.ICONIFIED);
}
});
lblminimize.setForeground(Color.RED);
lblminimize.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
lblminimize.setBounds(new Rectangle(452, 21, 12, 36));
lblminimize.setBackground(Color.BLACK);
lblminimize.setBounds(1466, 27, 14, 36);
frame.getContentPane().add(lblminimize);

JPanel panel = new JPanel();
panel.setBackground(Color.CYAN);
panel.setBounds(13, 16, 1447, 47);
frame.getContentPane().add(panel);

JLabel lblEmployeeTable = new JLabel("Employee Table  ");
panel.add(lblEmployeeTable);
lblEmployeeTable.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
lblEmployeeTable.setBackground(new Color(245, 255, 250));

JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(13, 75, 1504, 46);
frame.getContentPane().add(scrollPane);

table = new JTable();
table.setModel(new DefaultTableModel(
new Object[][] {
},
new String[] {
"emp_id", "first_name", "middle_name", "last_name", "gender", "job_code", "dob", "door_no", "street_name", "marital_status", "no_of_days_worked", "dept_code", "pincode", "payroll_id", "dept_name", "designation", "login_id"
}
));
String[] column={"emp_id", "first_name", "middle_name", "last_name", "gender", "job_code", "dob", "door_no", "street_name", "marital_status", "no_of_days_worked", "dept_code", "pincode", "payroll_id", "dept_name", "designation", "login_id"};
my_mysql3 obj=new my_mysql3();
table = new javax.swing.JTable(obj.my_db_select(),column);
scrollPane.setViewportView(table);



JLabel lblcancel = new JLabel("X");
lblcancel.setBounds(1490, 26, 25, 36);
frame.getContentPane().add(lblcancel);
lblcancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
lblcancel.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent e) {
System.exit(0);
}
});
lblcancel.setForeground(Color.RED);
lblcancel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
lblcancel.setBackground(Color.BLUE);

}
}

class my_mysql3 {
int size = 1;
public  String[][] my_db_select() {
String[][] data = new String[size][17];
try{  
 String JdbcURL = "jdbc:mysql://localhost:3306/lms";
      String Username = "root";
      String pass = "root123456";
 String query = "SELECT * FROM lms.employee LIMIT 0,1;";
Connection con = DriverManager.getConnection(JdbcURL, Username, pass);
System.out.println("Connected to MySQL database");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(query);
int i=0;
while(rs.next())  
{
for(int j=0;j<17;j++)
{
//System.out.print(rs.getString(j+1));
data[i][j]=rs.getString(j+1);
}
//System.out.println();
i=i+1;
}  

 for (int x=0;x<data.length;x++) {
for (int y=0;(data[x]!= null && y <data[x].length);y++) {
//System.out.print(data[x][y] + " ");
}
//System.out.println();
 }

st.close();
con.close();
}catch(Exception e){ System.out.println(e);}

return data;
}
}

