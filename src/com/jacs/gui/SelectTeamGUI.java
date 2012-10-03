package com.jacs.gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jacs.BasePanel;
import com.jacs.controller.GUIController;

public class SelectTeamGUI extends BasePanel{
	
	public SelectTeamGUI(String name, GUIController guiController){
		super(name, guiController);
		init();
	}
	
	private void init(){
		this.setBackground(Color.red);
		this.add(new JButton("CHOOSE"));
	}
	
}
