package jacs.controller;

import jacs.request.Requester;

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
	
	public MainController(JPanel container){
		this.container = container;
		this.cardLayout = (CardLayout) (this.container.getLayout());
		map = new HashMap<String, String>();
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
	
	public void sendVoteType(String key, String value){
		map.put(key, value);
	}
	
	public String getUsername(){
		return map.get("USERNAME").toString();
	}
}
