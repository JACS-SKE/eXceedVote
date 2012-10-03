package com.jacs.controller;

import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

public class GUIController {
	
	private CardLayout cardLayout;
	private JPanel container;
	
	public GUIController(JPanel container){
		this.container = container;
		this.cardLayout = (CardLayout) (this.container.getLayout());
	}
	
	public void swap(String name){
		cardLayout.show(container, name);
	}
}
