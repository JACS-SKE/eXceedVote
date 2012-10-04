package com.jacs.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.jacs.BasePanel;
import com.jacs.constant.Constant;
import com.jacs.controller.GUIController;

public class SelectTypeGUI extends BasePanel{
	
	private String[] projectType;
	private JPanel loginBox;
	public SelectTypeGUI(String name, GUIController guiController){
		super(name, guiController);
		projectType = new String[]{"Good UI","Good Coding","Best of All"};
		init();
	}
	
	private void init(){
		loginBox = new JPanel();
		loginBox.setOpaque(false);
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER,0,100);
		loginBox.setLayout(layout);
		
		JComboBox typeList = new JComboBox(projectType);
		typeList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
		        String typeName = (String)cb.getSelectedItem();
		        guiController.sendVoteType("VOTE_TYPE", typeName);
				//System.out.println(typeName);
			}
		});
		
		JButton btType = new JButton("Next");
		btType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guiController.swap(Constant.TEAM_PANEL);
			}
		});
		
		loginBox.add(typeList);
		loginBox.add(btType);
		this.add(loginBox);
	}
	
}
