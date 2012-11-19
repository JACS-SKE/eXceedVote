package jacs.controller;

import jacs.component.BasePanel;
import jacs.constant.Constant;
import jacs.gui.AuthGUI;
import jacs.gui.CriGUI;
import jacs.request.Requester;
import jacs.vote.Criteria;
import jacs.vote.Project;
import jacs.vote.User;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class MainController implements Observer{
	
	private CardLayout cardLayout;
	private Container container;
	private HashMap map;
	private Requester re;
	private List<Project> projectList;
	private List<Criteria> cateriaList;
	private User user;
	private String LOGIN_MSG;
	private String REGIS_MSG;
	private String VOTE_MSG;
	
	
	public MainController(Container container){
		this.container = container;
		this.cardLayout = (CardLayout) (this.container.getLayout());
		map = new HashMap<String, String>();
		projectList = new ArrayList<Project>();
		cateriaList = new ArrayList<Criteria>();
		LOGIN_MSG = "";
		REGIS_MSG = "";
		VOTE_MSG = "";
		user = new User("Guest", "Unknow Type", 0);
	}
	
	public List<Project> getProjectList() {
		return projectList;
	}
	
	public List<Criteria> getCriteriaList() {
		return cateriaList;
	}
	
	public void setRequester(Requester re){
		this.re = re;
	}
	
	public Requester getRequester(){
		return this.re;
	}
	
	public void swap(String name){
		cardLayout.show(container, name);
	}
	
	public void addMsg(String key, String value){
		map.put(key, value);
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getLoginMsg() {
		return LOGIN_MSG;
	}
	
	public void setLoginMsg(String lOGIN_MSG) {
		LOGIN_MSG = lOGIN_MSG;
	}
	
	public String getRegisMsg() {
		return REGIS_MSG;
	}
	
	public void setRegisMsg(String rEGIS_MSG) {
		REGIS_MSG = rEGIS_MSG;
	}
	
	public void setVoteMsg(String vOTE_MSG) {
		VOTE_MSG = vOTE_MSG;
	}
	
	public String getVoteMsg() {
		return VOTE_MSG;
	}
	
	public Component getChild(String name){
		Component comp = null;
		for(int i = 0 ; i < container.getComponentCount() ; i++){
			if(container.getComponent(i).getName().equals(name)){
				comp = container.getComponent(i);
				break;
			}
		}
		return comp;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg.equals("LOGIN_SUCCESS")){
			CriGUI criGUI = new CriGUI(Constant.CRI_PANEL, this);
			addPage(criGUI, Constant.CRI_PANEL);
			this.swap(Constant.CRI_PANEL);
		}else if(arg.equals("LOGIN_FAILED")){
			AuthGUI auth = (AuthGUI)this.getChild(Constant.AUTH_PANEL);
			auth.setLoginStatus("Check your username and password.");
		}
	}
	
	public void addPage(JPanel panel, String name){
		container.add(panel, name);
	}
	
}
