package com.jacs;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.jacs.controller.GUIController;

public class BasePanel extends JPanel{
	
	protected String pageName;
	protected GUIController guiController;
	private JPanel panelBgImg;
	
	public BasePanel(String name, GUIController controller){
		this.pageName = name;
		this.guiController = controller;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		 Image img = new ImageIcon("res/images/bg.png").getImage();
         Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
         setPreferredSize(size);
         setMinimumSize(size);
         setMaximumSize(size);
         setSize(size);
         setLayout(null);
         g.drawImage(img, 0, 0, null);
	}
	
	
	
}
