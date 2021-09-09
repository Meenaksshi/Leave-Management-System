package LEAVE_MANAGEMENT_SYSTEM;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.Font;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.Cursor;

public class DeleteEmployee {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void delete() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployee window = new DeleteEmployee();
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
	public DeleteEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 540, 418);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("Enter emp_id");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Monotype Corsiva", Font.ITALIC, 40));
		label_1.setBackground(new Color(245, 255, 250));
		label_1.setBounds(163, 113, 207, 56);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(150, 179, 242, 47);
		frame.getContentPane().add(textField);
		
		JButton button = new JButton("SUBMIT");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//connection with database
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "";
				try
				{
				  String JdbcURL = "jdbc:mysql://localhost:3306/LMS";
			      String Username = "root";
			      String pass = "root123456";
				  String query = "DELETE FROM Employee WHERE emp_id=?";
				  Connection c = DriverManager.getConnection(JdbcURL, Username, pass);
				  System.out.println("Connected to MySQL database");
				  PreparedStatement prestat = c.prepareStatement(query);	
				  String text = textField.getText();
				  prestat.setString(1,text);
				  prestat.executeUpdate();
				  System.out.println("1 row deleted");
				    msg = "Employee info deleted";
				}catch(Exception e1){ System.out.println(e1);
			}
			//message box
				JOptionPane.showMessageDialog(null, msg);
					
			}
		});
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		button.setBackground(Color.CYAN);
		button.setBounds(197, 326, 158, 46);
		frame.getContentPane().add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(10, 65, 520, 343);
		frame.getContentPane().add(panel_1);
		
		JLabel lblcancel = new JLabel("X");
		lblcancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblcancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(lblcancel);
		lblcancel.setForeground(Color.BLACK);
		lblcancel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
		lblcancel.setBounds(new Rectangle(486, 19, 25, 36));
		lblcancel.setBackground(Color.BLACK);
		
		JLabel lblminimize = new JLabel("-");
		lblminimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblminimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		frame.getContentPane().add(lblminimize);
		lblminimize.setForeground(Color.BLACK);
		lblminimize.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
		lblminimize.setBounds(new Rectangle(464, 19, 12, 36));
		lblminimize.setBackground(Color.BLACK);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 10, 520, 47);
		frame.getContentPane().add(panel);
		
		JLabel label_3 = new JLabel("Delete Employee");
		label_3.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		label_3.setBackground(new Color(245, 255, 250));
		panel.add(label_3);
	}

}
