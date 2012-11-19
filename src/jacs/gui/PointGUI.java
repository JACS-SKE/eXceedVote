package jacs.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;

import jacs.component.BasePanel;
import jacs.controller.MainController;

public class PointGUI extends BasePanel {
	
	private int votePoint;
	private JLabel pointLabel;

	public PointGUI(String name, MainController controller) {
		super(name, controller);
		votePoint  = mainController.getUser().getPoint();
		init();
	}
	
	public void init(){
		super.init();
		this.box.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		JPanel stage = new JPanel();
		stage.setPreferredSize(new Dimension(700,600));
		stage.setBackground(Color.white);
		pointLabel = new JLabel("Your can vote each team "+votePoint+" points.");
		pointLabel.setForeground(Color.red);
		pointLabel.setFont(new Font(pointLabel.getFont().getName(), pointLabel.getFont().getStyle(), 16));
		
		JPanel main = new JPanel();
		main.setBackground(Color.white);
		main.setPreferredSize(new Dimension(680,420));
		GridLayout grid = new GridLayout((mainController.getProjectList().size()/2)+1,2,10,10);
		main.setLayout(grid);
		
		for(int i = 0 ; i < mainController.getProjectList().size() ; i++){
			JPanel inside = new JPanel(new BorderLayout());
			inside.setPreferredSize(new Dimension(inside.getHeight(),50));
			JLabel name = new JLabel((i+1)+") "+mainController.getProjectList().get(i).getName());
			JSlider slide = new JSlider(JSlider.HORIZONTAL,10,0);
			slide.setPreferredSize(new Dimension(100,20));
			name.setForeground(Color.blue);
			
			inside.add(name, BorderLayout.WEST);
			inside.add(slide);
			main.add(inside);
			
		}
		
		JButton bt = new JButton("Submit");
		
		stage.add(pointLabel);
		stage.add(main);
		stage.add(bt);
		
		this.box.add(stage);
	}
}
