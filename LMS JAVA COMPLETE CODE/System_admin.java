package LEAVE_MANAGEMENT_SYSTEM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.Rectangle;

public class System_admin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void admin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System_admin window = new System_admin();
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
	public System_admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 514, 395);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnDelEmp = new JButton("Delete employee");
		btnDelEmp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEmployee set=new DeleteEmployee();
				//DeleteEmployee.delete();
				set.delete();
			}
		});

		btnDelEmp.setBackground(Color.CYAN);
		btnDelEmp.setForeground(Color.BLUE);
		btnDelEmp.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		btnDelEmp.setBounds(119, 285, 271, 45);
		frame.getContentPane().add(btnDelEmp);
		
		JButton btnViewEmp = new JButton("View Employee");
		btnViewEmp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnViewEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEmployee set=new ViewEmployee();
			    //ViewEmployee.view();
				set.view();
			}
		});
		btnViewEmp.setForeground(Color.BLUE);
		btnViewEmp.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		btnViewEmp.setBackground(Color.CYAN);
		btnViewEmp.setBounds(119, 161, 271, 45);
		frame.getContentPane().add(btnViewEmp);
		
		JLabel lblNewLabel = new JLabel("System Admin");
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setBounds(new Rectangle(142, 11, 222, 46));
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		lblNewLabel.setBackground(new Color(245, 255, 250));
		
		JLabel lblcancel = new JLabel("X");
		lblcancel.setForeground(Color.BLACK);
		frame.getContentPane().add(lblcancel);
		lblcancel.setBounds(new Rectangle(466, 15, 25, 36));
		lblcancel.setBackground(Color.BLACK);
		lblcancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblcancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblcancel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
		
		JLabel lblminimize = new JLabel("-");
		lblminimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblminimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		lblminimize.setForeground(Color.BLACK);
		frame.getContentPane().add(lblminimize);
		lblminimize.setFont(new Font("Imprint MT Shadow", Font.BOLD, 30));
		lblminimize.setBounds(new Rectangle(440, 15, 12, 36));
		lblminimize.setBackground(Color.BLACK);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 11, 494, 47);
		frame.getContentPane().add(panel);
		
		JButton btnUptEmp = new JButton("Update Employee");
		btnUptEmp.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		btnUptEmp.setBackground(Color.CYAN);
		btnUptEmp.setForeground(Color.BLUE);
		btnUptEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//.....update
				Update_Emp obj = new Update_Emp();
				obj.update();
			}
		});
		btnUptEmp.setBounds(119, 223, 271, 45);
		frame.getContentPane().add(btnUptEmp);
		
		JButton btnCreateEmp = new JButton("Create Employee");
		btnCreateEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//.....CREATE
				Create_Emp obj = new Create_Emp();
				obj.create_emp();
			}
		});
		btnCreateEmp.setForeground(Color.BLUE);
		btnCreateEmp.setBackground(Color.CYAN);
		btnCreateEmp.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		btnCreateEmp.setBounds(119, 99, 271, 45);
		frame.getContentPane().add(btnCreateEmp);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(10, 67, 494, 318);
		frame.getContentPane().add(panel_1);
	}
}

