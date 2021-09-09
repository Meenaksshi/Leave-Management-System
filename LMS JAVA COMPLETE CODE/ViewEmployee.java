package LEAVE_MANAGEMENT_SYSTEM;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;

public class ViewEmployee {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void view() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmployee window = new ViewEmployee();
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
	public ViewEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 526, 384);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter emp_id");
		lblNewLabel.setBackground(new Color(245, 255, 250));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.ITALIC, 40));
		lblNewLabel.setBounds(163, 123, 207, 56);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(146, 189, 242, 47);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("SUBMIT");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table_view obj=new Table_view();
			    //Table_view.disp();
				obj.disp();
			}
		});
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		button.setBackground(Color.CYAN);
		button.setBounds(194, 308, 158, 46);
		frame.getContentPane().add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(10, 67, 506, 307);
		frame.getContentPane().add(panel_1);
		
		JLabel lblViewEmployee = new JLabel("View Employee");
		frame.getContentPane().add(lblViewEmployee);
		lblViewEmployee.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		lblViewEmployee.setBounds(new Rectangle(146, 11, 242, 46));
		lblViewEmployee.setBackground(new Color(245, 255, 250));
		
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
		lblcancel.setBounds(new Rectangle(474, 21, 25, 36));
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
		lblminimize.setBounds(new Rectangle(452, 21, 12, 36));
		lblminimize.setBackground(Color.BLACK);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 10, 506, 47);
		frame.getContentPane().add(panel);
	}
}

