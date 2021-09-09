package LEAVE_MANAGEMENT_SYSTEM;

import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Enumeration;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Update_Emp {

	private JFrame frmUpdateEmp;
	private ButtonGroup actions = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public void update() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Emp window = new Update_Emp();
					window.frmUpdateEmp.setLocationRelativeTo(null);
					window.frmUpdateEmp.setVisible(true);
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
	public Update_Emp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateEmp = new JFrame();
		frmUpdateEmp.getContentPane().setBackground(Color.BLACK);
		frmUpdateEmp.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 10, 527, 48);
		frmUpdateEmp.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUpdateEmp = new JLabel("Update Employee Record");
		lblUpdateEmp.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUpdateEmp.setBounds(10, 0, 389, 48);
		panel.add(lblUpdateEmp);
		
		JLabel lblMinimize = new JLabel("-");
		lblMinimize.setFont(new Font("Dialog", Font.BOLD, 40));
		lblMinimize.setBounds(449, 15, 29, 13);
		panel.add(lblMinimize);
		lblMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmUpdateEmp.setState(JFrame.ICONIFIED);
			}
		});
		
		JLabel lblClose = new JLabel("x");
		lblClose.setFont(new Font("Dialog", Font.BOLD, 40));
		lblClose.setBounds(488, 3, 29, 37);
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
		panel_1.setBounds(10, 68, 527, 308);
		frmUpdateEmp.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnAddr = new JRadioButton("Address");
		rdbtnAddr.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnAddr.setBackground(Color.CYAN);
		rdbtnAddr.setBounds(173, 100, 171, 33);
		panel_1.add(rdbtnAddr);
		actions.add(rdbtnAddr);
		
		JRadioButton rdbtnMailId = new JRadioButton("Mail ID");
		rdbtnMailId.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnMailId.setBackground(Color.CYAN);
		rdbtnMailId.setBounds(173, 146, 171, 33);
		panel_1.add(rdbtnMailId);
		actions.add(rdbtnMailId);
		
		JRadioButton rdbtnPhoneNo = new JRadioButton("Phone number");
		rdbtnPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtnPhoneNo.setBackground(Color.CYAN);
		rdbtnPhoneNo.setBounds(173, 192, 171, 33);
		panel_1.add(rdbtnPhoneNo);
		actions.add(rdbtnPhoneNo);
		
		JLabel lblNewLabel_3 = new JLabel("You can update the following details only.");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(53, 22, 438, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Which one do you want to update?");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(82, 57, 369, 25);
		panel_1.add(lblNewLabel_4);
		
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
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNext.setBackground(Color.CYAN);
		btnNext.setBounds(388, 241, 103, 33);
		panel_1.add(btnNext);
		frmUpdateEmp.setUndecorated(true);
		frmUpdateEmp.setBounds(100, 100, 547, 386);
		frmUpdateEmp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnAddr.isSelected()) {
							UpdateAddr frame1=new UpdateAddr();
							frame1.update_addr();					
				}
				else if(rdbtnMailId.isSelected()) {
					UpdateMailId frame2=new UpdateMailId();
					frame2.update_mail();	
				}
				else {
					UpdatePhone frame3=new UpdatePhone();
					frame3.update_phone();	
				}
				
				
			}	
		}
		);		
	}
}
