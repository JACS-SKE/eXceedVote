package com.jacs.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
		txtUser = new JTextField(10);
		txtPass = new JPasswordField(10);
		
		this.add(new JLabel("Username : ")); 
		this.add(txtUser);
		this.add(new JLabel("Password : "));
		this.add(txtPass);
		this.loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guiController.swap(Constant.TYPE_PANEL);
			}
		});
		
		this.add(loginButton);
		
	}
	
}