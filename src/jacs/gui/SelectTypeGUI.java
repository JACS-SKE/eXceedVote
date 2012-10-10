package jacs.gui;

import jacs.component.BasePanel;
import jacs.constant.Constant;
import jacs.controller.MainController;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class SelectTypeGUI extends BasePanel{
	
	private String[] projectType;

	public SelectTypeGUI(String name, MainController guiController){
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
