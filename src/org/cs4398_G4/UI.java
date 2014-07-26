package org.cs4398_G4;

import org.cs4398_G4.examples.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField password;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
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
	public UI() {
		setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		setTitle("Home Automation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 424, 252);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		tabbedPane.addTab("Log In", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setBounds(91, 85, 46, 14);
		panel.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(91, 113, 64, 14);
		panel.add(lblPassword);
		
		//password text field
		password = new JPasswordField();
		password.setBounds(176, 110, 138, 20);
		panel.add(password);
		password.setColumns(10);
		
		//user ID text field
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(176, 82, 138, 20);
		panel.add(textField_1);
		
		final User user = new User();
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.logOn(password.getText()))
				{
					//create tabs after login here
					JPanel panel_1 = new JPanel();
					panel_1.setBackground(new Color(128, 128, 128));
					tabbedPane.addTab("Lights", null, panel_1, null);
					panel_1.setLayout(null);
					
					JLabel lblToggleLights = new JLabel("TOGGLE LIGHTS");
					lblToggleLights.setHorizontalAlignment(SwingConstants.CENTER);
					lblToggleLights.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblToggleLights.setBounds(78, 11, 251, 32);
					panel_1.add(lblToggleLights);
					
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(128, 128, 128));
					tabbedPane.addTab("Locks", null, panel_2, null);
					panel_2.setLayout(null);
					
					JLabel lblLockunlock = new JLabel("LOCK/UNLOCK");
					lblLockunlock.setHorizontalAlignment(SwingConstants.CENTER);
					lblLockunlock.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblLockunlock.setBounds(78, 11, 251, 32);
					panel_2.add(lblLockunlock);
					
					JPanel panel_3 = new JPanel();
					panel_3.setBackground(new Color(128, 128, 128));
					tabbedPane.addTab("HVAC", null, panel_3, null);
					panel_3.setLayout(null);
					
					JLabel lblHvacControl = new JLabel("HVAC CONTROL");
					lblHvacControl.setHorizontalAlignment(SwingConstants.CENTER);
					lblHvacControl.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblHvacControl.setBounds(78, 11, 251, 32);
					panel_3.add(lblHvacControl);
					
					JPanel panel_5 = new JPanel();
					panel_5.setBackground(new Color(128, 128, 128));
					tabbedPane.addTab("Behaviors", null, panel_5, null);
					panel_5.setLayout(null);
					
					JPanel panel_4 = new JPanel();
					panel_4.setBackground(new Color(128, 128, 128));
					tabbedPane.addTab("Add/Remove", null, panel_4, null);
					panel_4.setLayout(null);
					
					JLabel lblName = new JLabel("Name:");
					lblName.setBounds(50, 73, 46, 14);
					panel_4.add(lblName);
					
					JLabel lblInputPin = new JLabel("Input Pin:");
					lblInputPin.setBounds(50, 98, 57, 14);
					panel_4.add(lblInputPin);
					
					JLabel lblOutputPin = new JLabel("Output Pin:");
					lblOutputPin.setBounds(50, 123, 57, 14);
					panel_4.add(lblOutputPin);
					
					JLabel lblRoom = new JLabel("Room:");
					lblRoom.setBounds(50, 148, 57, 14);
					panel_4.add(lblRoom);
					
					textField = new JTextField();
					textField.setBounds(114, 67, 204, 20);
					panel_4.add(textField);
					textField.setColumns(10);
					
					textField_2 = new JTextField();
					textField_2.setColumns(10);
					textField_2.setBounds(114, 92, 204, 20);
					panel_4.add(textField_2);
					
					textField_3 = new JTextField();
					textField_3.setColumns(10);
					textField_3.setBounds(114, 117, 204, 20);
					panel_4.add(textField_3);
					
					textField_4 = new JTextField();
					textField_4.setColumns(10);
					textField_4.setBounds(114, 142, 204, 20);
					panel_4.add(textField_4);
					
					JButton btnNewButton = new JButton("Add");
					btnNewButton.setBounds(229, 173, 89, 23);
					panel_4.add(btnNewButton);
					
					JButton btnRemove = new JButton("Remove");
					btnRemove.setBounds(114, 173, 89, 23);
					panel_4.add(btnRemove);
					
					JLabel lblNewLabel = new JLabel("ADD/REMOVE COMPONENTS");
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblNewLabel.setBounds(85, 11, 251, 32);
					lblNewLabel.setHorizontalAlignment(JTextField.CENTER);
					panel_4.add(lblNewLabel);
				}
			}
		});
		btnOk.setBounds(250, 141, 64, 20);
		panel.add(btnOk);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(176, 141, 64, 20);
		panel.add(btnClear);	
		
		//new tabs
		
	}
}