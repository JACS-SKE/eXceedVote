package com.jacs.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jacs.constant.Constant;
import com.jacs.controller.GUIController;


public class MainGUI extends JFrame{
	
	private CardLayout cardLayout;
	private JPanel container;
	private AuthGUI authPanel;
	private SelectTypeGUI typePanel;
	private SelectTeamGUI teamPanel;
	
	private GUIController guiController;
	
	public MainGUI(){
		init();
	}
	
	private void init(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("eXceed Vote :: By JACS");
		this.setPreferredSize(new Dimension(800, 600));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("res/images/icon.png"));
		this.cardLayout = new CardLayout();
		container = new JPanel(cardLayout);
		this.setContentPane(container);
		guiController = new GUIController(container);
		
		this.authPanel = new AuthGUI(this.guiController);
		this.typePanel = new SelectTypeGUI();
		this.teamPanel = new SelectTeamGUI();
		
		container.add(authPanel, Constant.AUTH_PANEL);
		container.add(typePanel, Constant.TYPE_PANEL);
		container.add(teamPanel, Constant.TEAM_PANEL);
		
		
		this.pack();
	}
	
	public void run(){
		this.setVisible(true);
	}
	
}
