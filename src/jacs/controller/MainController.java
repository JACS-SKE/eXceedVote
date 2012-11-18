package jacs.controller;

import jacs.request.Requester;
import jacs.vote.Cateria;
import jacs.vote.Project;
import jacs.vote.User;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

public class MainController {
	
	private CardLayout cardLayout;
	private JPanel container;
	private HashMap map;
	private Requester re;
	private List<Project> projectList;
	private List<Cateria> cateriaList;
	private User user;
	private String LOGIN_MSG;
	private String REGIS_MSG;
	private String VOTE_MSG;
	
	
	public MainController(JPanel container){
		this.container = container;
		this.cardLayout = (CardLayout) (this.container.getLayout());
		map = new HashMap<String, String>();
		projectList = new ArrayList<Project>();
		cateriaList = new ArrayList<Cateria>();
		LOGIN_MSG = "";
		REGIS_MSG = "";
		VOTE_MSG = "";
	}
	
	public List<Project> getProjectList() {
		return projectList;
	}
	
	public List<Cateria> getCateriaList() {
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
}
