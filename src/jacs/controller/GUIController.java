package jacs.controller;

import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.JPanel;

public class GUIController {
	
	private CardLayout cardLayout;
	private JPanel container;
	private HashMap map;
	
	public GUIController(JPanel container){
		this.container = container;
		this.cardLayout = (CardLayout) (this.container.getLayout());
		map = new HashMap<String, String>();
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
}
