package com.jacs.gui;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;


public class VoteGUI extends JFrame{
	
	CardLayout cards;
	
	public VoteGUI(){
		init();
	}
	
	private void init(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("eXceed Vote :: By JACS");
		this.setPreferredSize(new Dimension(800, 600));
		this.cards = new CardLayout();
		this.setLayout(cards);
		
		this.pack();
	}
	
	private void initCards(){
		
	}
	
	public void run(){
		this.setVisible(true);
	}
	
}
