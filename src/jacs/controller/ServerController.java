package jacs.controller;

import jacs.request.Requester;

import java.util.List;

public class ServerController{

	private Requester client;
	private MainController controller;
	
	public ServerController(MainController controller){
		this.controller = controller;
		client = new Requester(this);
		this.controller.setRequester(client);
		try {
			client.run();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public MainController getMainController(){
		return this.controller;
	}
	
	
}
