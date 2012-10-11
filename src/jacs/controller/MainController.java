package jacs.controller;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

public class MainController {
	
	private CardLayout cardLayout;
	private JPanel container;
	private HashMap map;
	private List<String> serverList;
	
	public MainController(JPanel container){
		this.container = container;
		this.cardLayout = (CardLayout) (this.container.getLayout());
		map = new HashMap<String, String>();
		serverList = new ArrayList<String>();
	}
	
	public void swap(String name){
		cardLayout.show(container, name);
	}
	
	public void sendAuthMsg(String key, String value){
		map.put(key, value);
	}
	
	public void sendVoteType(String key, String value){
		map.put(key, value);
	}
	
	public String getUsername(){
		return map.get("USERNAME").toString();
	}
	
	public String getType(){
		return map.get("VOTE_TYPE").toString();
	}
	
	public void sendToServer(String msg){
		serverList.add(msg);
	}
	
	public List getServerList(){
		return this.serverList;
	}
	
}
