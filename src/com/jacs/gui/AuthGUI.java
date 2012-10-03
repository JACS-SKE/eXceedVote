package com.jacs.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jacs.BasePanel;
import com.jacs.constant.Constant;
import com.jacs.controller.GUIController;

public class AuthGUI extends BasePanel{
	
	private JButton loginButton;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JPanel loginBox;
	
	public AuthGUI(String name, GUIController guiController){
		super(name, guiController);
		init();
	}
	
	private void init(){
		loginBox = new JPanel();
		loginBox.setOpaque(false);
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER,0,100);
		loginBox.setLayout(layout);
		txtUser = new JTextField(10);
		txtPass = new JPasswordField(10);
		
		loginBox.add(new JLabel("Username : ")); 
		loginBox.add(txtUser);
		loginBox.add(new JLabel("Password : "));
		loginBox.add(txtPass);
		
		this.loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guiController.swap(Constant.TYPE_PANEL);
			}
		});
		
		loginBox.add(loginButton);
		this.add(loginBox);
		
	}
	
}