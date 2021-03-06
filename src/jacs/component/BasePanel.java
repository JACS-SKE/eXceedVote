package jacs.component;

import jacs.controller.MainController;
import jacs.controller.ServerController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class BasePanel extends JPanel{
	
	protected String pageName;
	protected MainController mainController;
	private JPanel topPanel;
	protected JPanel box;
	protected JLabel status;
	
	public BasePanel(String name, MainController controller){
		this.pageName = name;
		this.setName(pageName);
		this.mainController = controller;
		
		box = new JPanel();
		box.setOpaque(false);
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER,0,100);
		box.setLayout(layout);

		topPanel = new JPanel(){

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image img = new ImageIcon("res/images/topbar.png").getImage();
				Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
				g.drawImage(img, 0, 0, null);
			}
			
		};
		
		topPanel.setPreferredSize(new Dimension(800, 50));
		topPanel.setLayout(new BorderLayout());
		setLayout(new BorderLayout());
		
		JLabel label = new JLabel();
		label.setText("      eXceed Vote   >   "+this.pageName);
		label.setForeground(Color.white);
		
		status = new JLabel();
		status.setText("             Welcome "+mainController.getUser().getName()+" ("+mainController.getUser().getType()+")");
		status.setForeground(Color.white);
		topPanel.add(label, BorderLayout.WEST);
		topPanel.add(status, BorderLayout.CENTER);
		
		this.add(topPanel, BorderLayout.NORTH);
		JLabel bottom = new JLabel("Developed by JACS Team SKE'09");
		this.add(bottom, BorderLayout.SOUTH);
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
	
	public void init(){
		status.setText("             Welcome "+mainController.getUser().getName()+" ("+mainController.getUser().getType()+")");
		this.add(this.box);
	}
	
}
