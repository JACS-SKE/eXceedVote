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
	
	public AuthGUI(String name, GUIController guiController){
		super(name, guiController);
		init();
	}
	
	private void init(){
		txtUser = new JTextField(10);
		txtPass = new JPasswordField(10);
		
		this.box.add(new JLabel("Username : ")); 
		this.box.add(txtUser);
		this.box.add(new JLabel("Password : "));
		this.box.add(txtPass);
		
		this.loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtUser.getText().toString().equals("chayanon") && txtPass.getText().toString().equals("1234")){
					guiController.sendAuthMsg("USERNAME", "Chayanon");
					guiController.swap(Constant.TYPE_PANEL);
				}
			}
		});
		
		this.box.add(loginButton);
		this.add(this.box);
	}
	
}