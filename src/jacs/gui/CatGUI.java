package jacs.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import jacs.component.BasePanel;
import jacs.controller.MainController;

public class CatGUI extends BasePanel {

	public CatGUI(String name, MainController controller) {
		super(name, controller);
		System.out.println(mainController.getUser().getName());
		
	}
	
	public void init(){
		super.init();
	}

}
