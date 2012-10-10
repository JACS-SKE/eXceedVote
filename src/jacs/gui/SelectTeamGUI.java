package jacs.gui;

import jacs.component.BasePanel;
import jacs.constant.Constant;
import jacs.controller.MainController;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SelectTeamGUI extends BasePanel{
	
	private String[] nameString;
	private String selected;
	
	public SelectTeamGUI(String name, MainController guiController){
		super(name, guiController);
		nameString = new String[]{"Durian", "Hook Hook", "JACS", "ANT2"};
		init();
	}
	
	private void init(){
		
		JComboBox typeList = new JComboBox(nameString);
		typeList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
		        selected = (String)cb.getSelectedItem();
		        //guiController.sendVoteType("VOTE_TYPE", typeName);
				//System.out.println(typeName);
			}
		});
		
		JButton btType = new JButton("Submit");
		btType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//guiController.swap(Constant.TEAM_PANEL);
				System.out.println(guiController.getUsername()  + " choose type " + guiController.getType() +" and voted "  + selected);
				guiController.swap(Constant.TYPE_PANEL);
			}
		});
		
		this.box.add(typeList);
		this.box.add(btType);
		this.add(this.box);
	}
	
}
