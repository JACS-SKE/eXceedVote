package com.jacs.gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jacs.controller.GUIController;

public class SelectTypeGUI extends JPanel{
	
	GUIController guiController;
	
	public SelectTypeGUI(){
		init();
	}
	
	private void init(){
		this.setBackground(Color.orange);
		this.add(new JButton("CHOOSE"));
	}
	
}
