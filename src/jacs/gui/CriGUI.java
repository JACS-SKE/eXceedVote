package jacs.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import jacs.component.BasePanel;
import jacs.controller.MainController;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.ws.handler.MessageContext.Scope;

public class CriGUI extends BasePanel {
	
	private JList proList;
	private JList dataList;
	private int[][] res;
	private int nowSelect = 0;
	

	public CriGUI(String name, MainController controller) {
		super(name, controller);
		init();
	}
	
	public void init(){
		super.init();
		this.box.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		JPanel criteria = new JPanel();
		criteria.setBackground(Color.white);
		criteria.setPreferredSize(new Dimension(200,600));
		
		JPanel project = new JPanel();
		project.setBackground(Color.white);
		project.setPreferredSize(new Dimension(200,600));
		
		JPanel space = new JPanel();
		space.setOpaque(false);
		space.setPreferredSize(new Dimension(50,600));
		
		JPanel space2 = new JPanel();
		space2.setOpaque(false);
		space2.setPreferredSize(new Dimension(50,600));
		
		JPanel result = new JPanel();
		result.setBackground(Color.white);
		result.setPreferredSize(new Dimension(280,200));
		
		//Criteria JList and ScrollPane
		int pNum = mainController.getCriteriaList().size();
		res = new int[pNum][2];
		
		DefaultListModel info = new DefaultListModel();
		for(int i = 0 ; i < pNum ; i++)
			info.addElement(mainController.getCriteriaList().get(i).getName());
		
		dataList = new JList(info);
		dataList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				boolean adjust = e.getValueIsAdjusting();
		        if (!adjust) {
		        	JList list = (JList) e.getSource();
		        	int selections[] = list.getSelectedIndices();
		        	Object selectionValues[] = list.getSelectedValues();
		        	for (int i = 0, n = selections.length; i < n; i++) {
		        		nowSelect = selections[i];
		        	}
		        }
		        proList.setSelectedIndex(res[nowSelect][1]);
			}
			
		});
		JScrollPane scrollPane = new JScrollPane(dataList);
		scrollPane.setPreferredSize(new Dimension(190,470));
		
		JLabel chooseCri = new JLabel("1. Choose Criteria");
		chooseCri.setForeground(Color.red);
		criteria.add(chooseCri);
		criteria.add(scrollPane);
		
		//Project
		int proNum = mainController.getProjectList().size();
		DefaultListModel pinfo = new DefaultListModel();
		for(int i = 0 ; i < proNum ; i++)
			pinfo.addElement(mainController.getProjectList().get(i).getName());
		
		proList = new JList(pinfo);
		proList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				boolean adjust = e.getValueIsAdjusting();
		        if (!adjust) {
		        	JList list = (JList) e.getSource();
		        	int selections[] = list.getSelectedIndices();
		        	Object selectionValues[] = list.getSelectedValues();
		        	for (int i = 0, n = selections.length; i < n; i++) {
		        		res[nowSelect][1] = selections[i];
		        	}
		        }
			}
			
		});
		
		JScrollPane proScrollPane = new JScrollPane(proList);
		proScrollPane.setPreferredSize(new Dimension(190,470));
		
		JLabel choosePro = new JLabel("2. Choose Project");
		choosePro.setForeground(Color.red);
		project.add(choosePro);
		project.add(proScrollPane);
		
		
		this.box.add(criteria);
		this.box.add(space);
		this.box.add(project);
		this.box.add(space2);
		this.box.add(result);
	}

}
