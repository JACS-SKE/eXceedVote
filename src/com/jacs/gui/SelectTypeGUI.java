package com.jacs.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.jacs.component.BasePanel;
import com.jacs.constant.Constant;
import com.jacs.controller.GUIController;

public class SelectTypeGUI extends BasePanel{
	
	private String[] projectType;

	public SelectTypeGUI(String name, GUIController guiController){
		super(name, guiController);
		projectType = new String[]{"Good UI","Good Coding","Best of All"};
		init();
	}
	
	private void init(){
		
		JComboBox typeList = new JComboBox(projectType);
		typeList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
		        String typeName = (String)cb.getSelectedItem();
		        guiController.sendVoteType("VOTE_TYPE", typeName);
			}
		});
		
		JButton btType = new JButton("Next");
		btType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guiController.swap(Constant.TEAM_PANEL);
			}
		});
		
		this.box.add(typeList);
		this.box.add(btType);
		this.add(box);
	}
	
}
