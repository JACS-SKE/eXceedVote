package jacs.gui;

import jacs.constant.Constant;
import jacs.controller.MainController;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class MainGUI extends JFrame{
	
	private CardLayout cardLayout;
	private Container container;
	private AuthGUI authPanel;
	
	private static MainController mainController;
	
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
		container = this.getContentPane();
		container.setLayout(cardLayout);
		mainController = new MainController(container);
		
		this.authPanel = new AuthGUI(Constant.AUTH_PANEL, this.mainController);
		container.add(authPanel, Constant.AUTH_PANEL);

		this.pack();
	}
	
	public void run(){
		this.setVisible(true);
	}
	
	public MainController getController(){
		return this.mainController;
	}
}
