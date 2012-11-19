package jacs.gui;

import jacs.component.BasePanel;
import jacs.controller.MainController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PointGUI extends BasePanel {
	
	private int votePoint;
	private JLabel pointLabel;
	private List<JLabel> label = new ArrayList<JLabel>();

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
			JLabel name = new JLabel((i+1)+") "+mainController.getProjectList().get(i).getName()+"  ");
			JSlider slide = new JSlider(JSlider.HORIZONTAL,mainController.getUser().getPoint(),0);
			slide.setName(""+i);
			slide.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					JSlider s = (JSlider)e.getSource();
					label.get(Integer.parseInt(s.getName())).setText(s.getValue()+"");
				}
			});
			name.setForeground(Color.blue);
			
			JLabel score = new JLabel(slide.getValue()+"");
			label.add(score);
			
			inside.add(name, BorderLayout.WEST);
			inside.add(score, BorderLayout.CENTER);
			inside.add(slide, BorderLayout.EAST);
			
			main.add(inside);
			
		}
		
		JButton bt = new JButton("Submit");
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//VOTE:criID1,proName1:criID2,proName2#POINT:proID1,point1:proId2,point2#user
				StringBuilder sb = new StringBuilder("#POINT");
				for(int i = 0 ; i < mainController.getProjectList().size() ; i++){
					sb.append(":"+mainController.getProjectList().get(i).getId()+",");
					sb.append(label.get(i).getText().toString());
				}
				sb.append("#"+mainController.getUser().getName());
				mainController.addVoteResult(sb.toString());
				mainController.getRequester().sendMessage(mainController.getVoteResult());
			}
		});
		
		stage.add(pointLabel);
		stage.add(main);
		stage.add(bt);
		
		this.box.add(stage);
	}
}
