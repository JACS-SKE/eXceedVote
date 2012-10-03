package com.jacs.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jacs.constant.Constant;
import com.jacs.controller.GUIController;

public class AuthGUI extends JPanel{
	
	private GUIController guiController;
	private JButton loginButton;
	
	public AuthGUI(GUIController gui){
		this.guiController = gui;
		init();
	}
	
	private void init(){
		this.setBackground(Color.green);
		this.add(new JTextField("TEST"));
		
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
