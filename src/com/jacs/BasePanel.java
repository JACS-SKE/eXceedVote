package com.jacs;

import javax.swing.JPanel;

import com.jacs.controller.GUIController;

public class BasePanel extends JPanel{
	
	protected String pageName;
	protected GUIController guiController;
	
	public BasePanel(String name, GUIController controller){
		this.pageName = name;
		this.guiController = controller;
	}
}
