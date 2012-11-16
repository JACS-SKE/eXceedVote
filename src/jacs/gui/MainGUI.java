package jacs.gui;

import jacs.constant.Constant;
import jacs.controller.MainController;
import jacs.controller.ServerController;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class MainGUI extends JFrame{
	
	private CardLayout cardLayout;
	private JPanel container;
	private AuthGUI authPanel;
	private RegisGUI regisPanel; 
	
	private MainController guiController;
	
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
		guiController = new MainController(container);
		
		//add panel here
		this.authPanel = new AuthGUI("Login", this.guiController);
		this.regisPanel = new RegisGUI("Registration", this.guiController);
		
		container.add(authPanel, Constant.AUTH_PANEL);
		container.add(regisPanel, Constant.REGIS_PANEL);
		
		this.pack();
	}
	
	public void run(){
		this.setVisible(true);
	}
	
	public MainController getController(){
		return this.guiController;
	}
}
