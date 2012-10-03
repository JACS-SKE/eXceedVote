package com.jacs.gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jacs.controller.GUIController;

public class SelectTeamGUI extends JPanel{
	
	GUIController guiController;
	
	public SelectTeamGUI(){
		init();
	}
	
	private void init(){
		this.setBackground(Color.red);
		this.add(new JButton("CHOOSE"));
	}
	
}
