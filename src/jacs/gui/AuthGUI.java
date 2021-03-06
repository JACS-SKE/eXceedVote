package jacs.gui;

import jacs.component.BasePanel;
import jacs.constant.Constant;
import jacs.controller.MainController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class AuthGUI extends BasePanel{
	
	private JButton loginButton;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JPanel loginPanel;
	private JLabel loginStatus;
	private JPanel userPanel;
	private JPanel passPanel;
	private JPanel loginBox;
	private JPanel statePanel;
	private JPanel submitPanel;
	private GridLayout gridLogin;
	
	public AuthGUI(String name, MainController mainController){
		super(name, mainController);
		init();
	}
	
	public void init(){
		super.init();
		gridLogin = new GridLayout(5,1);
		
		loginBox = new JPanel();
		loginBox.setBackground(Color.white);
		loginBox.setPreferredSize(new Dimension(250,210));
		loginBox.setLayout(gridLogin);
		
		userPanel = new JPanel();
		userPanel.setOpaque(false);
		passPanel = new JPanel();
		passPanel.setOpaque(false);
		submitPanel = new JPanel();
		submitPanel.setOpaque(false);
		
		txtUser = new JTextField(10);
		txtPass = new JPasswordField(10);
		
		userPanel.add(new JLabel("Username : ")); 
		userPanel.add(txtUser);
		passPanel.add(new JLabel("Password : "));
		passPanel.add(txtPass);
		
		loginStatus = new JLabel("Input you username and password.");
		loginStatus.setForeground(Color.RED);
		statePanel = new JPanel();
		statePanel.setOpaque(false);
		statePanel.add(loginStatus);
		loginButton = new JButton(new ImageIcon("res/images/btn_login.png"));
		loginButton.setBorder(BorderFactory.createEmptyBorder());
		loginButton.setPressedIcon(new ImageIcon("res/images/btn_login_pressed.png"));
		loginButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				mainController.getRequester().sendMessage("LOGIN,"+txtUser.getText().toString()+","+txtPass.getText().toString());
				txtPass.setText("");
				txtUser.setText("");
			}
		});
		
		loginPanel = new JPanel();
		loginPanel.add(new JLabel("Login"));
		loginPanel.setOpaque(false);
		
		submitPanel.add(loginButton);
		loginBox.add(loginPanel);
		loginBox.add(userPanel);
		loginBox.add(passPanel);
		loginBox.add(submitPanel);
		loginBox.add(statePanel);
		this.box.add(loginBox);
	}
	
	public void setLoginStatus(String status){
		this.loginStatus.setText(status);
	}
	
}