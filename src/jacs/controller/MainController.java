package jacs.controller;

import jacs.request.Requester;
import jacs.vote.Project;

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
	private List<String> cateriaList;
	
	
	public MainController(JPanel container){
		this.container = container;
		this.cardLayout = (CardLayout) (this.container.getLayout());
		map = new HashMap<String, String>();
		projectList = new ArrayList<Project>();
		cateriaList = new ArrayList<String>();
	}
	
	public List<Project> getProjectList() {
		return projectList;
	}
	
	public List<String> getCateriaList() {
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
	
	public String getUsername(){
		return map.get("USERNAME").toString();
	}
}
