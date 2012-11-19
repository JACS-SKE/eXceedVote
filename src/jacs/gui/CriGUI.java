package jacs.gui;

import jacs.component.BasePanel;
import jacs.constant.Constant;
import jacs.controller.MainController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CriGUI extends BasePanel {
	
	private JList proList;
	private JList dataList;
	private int[][] res;
	private int nowSelect = 0;
	private JTextArea show;
	

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
		result.setPreferredSize(new Dimension(280,220));
		
		//Criteria JList and ScrollPane
		int pNum = mainController.getCriteriaList().size();
		res = new int[pNum][2];
		
		DefaultListModel info = new DefaultListModel();
		for(int i = 0 ; i < pNum ; i++)
			info.addElement(mainController.getCriteriaList().get(i).getName());
		
		dataList = new JList(info);
		dataList.setForeground(Color.magenta);
		dataList.setSelectionBackground(Color.lightGray);
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
		proList.setForeground(new Color(0x00a651));
		proList.setSelectionBackground(Color.lightGray);
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
		        		updateResult();
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
		
		JLabel resultLabel = new JLabel("3. Check your vote result");
		resultLabel.setForeground(Color.red);
		show = new JTextArea();
		show.setEditable(false);
		show.setPreferredSize(new Dimension(270,150));
		show.setBackground(new Color(0xffeca2));
		
		
		result.add(resultLabel);
		result.add(show);
		
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = {"Confirm Vote", "Back to Vote"};
				int n = JOptionPane.showOptionDialog(new JFrame(),"Please check your voting", "Confirm your voting", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
				
				if(n == 0){
					//VOTE:criID1,proName1:criID2,proName2#POINT:proID1,point1:proId2,point2#user
					StringBuilder sb = new StringBuilder("VOTE:");
					for(int i = 0 ; i < mainController.getCriteriaList().size() ; i++){
						sb.append(mainController.getCriteriaList().get(i).getId()+",");
						sb.append(mainController.getProjectList().get(res[i][1]).getName()+":");
					}
					mainController.addVoteResult(sb.toString());
					mainController.addPage(new PointGUI(Constant.POINT_PANEL, mainController), Constant.POINT_PANEL);
					mainController.swap(Constant.POINT_PANEL);
					mainController.clearPanel(pageName);
				}
			}
		});
		result.add(submit);
		
		this.box.add(criteria);
		this.box.add(space);
		this.box.add(project);
		this.box.add(space2);
		this.box.add(result);
	}
	
	private void updateResult(){
		show.setText("");
		for(int i = 0 ; i < mainController.getCriteriaList().size() ; i++){
			show.append((i+1)+") "+mainController.getCriteriaList().get(i).getName()+"   -->   "+mainController.getProjectList().get(res[i][1]).getName()+"\n");
		}
	}

}
