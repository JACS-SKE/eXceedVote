package jacs.request;


import jacs.controller.MainController;
import jacs.controller.ServerController;
import jacs.vote.Project;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Requester{
	private Socket requestSocket;
	private ObjectOutputStream out;
 	private ObjectInputStream in;
 	private String message;
 	private int port = 9999;
 	private ServerController serverController;
 	private MainController mainController;
 	
	public Requester(ServerController serverController){
		this.serverController = serverController;
		this.mainController = this.serverController.getMainController();
	}

	public void run() throws ClassNotFoundException{
		try{
			requestSocket = new Socket("192.168.1.49", port);
			System.out.println("Connected to localhost in port "+port);
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			while(true){
				String str = (String)in.readObject();
				System.out.println(str);
				//String str = "INIT:1,name1:2,name2:3,name3:4,name4#CAT:Best Coding:Best GUI:Best of All";
				String tmp = str.substring(0, 4);
				if(tmp.equals("INIT")){
					//INIT -> ProjectList,Cateria
					//INIT:id1,name1:id2,name2:id3,name3:id4,name4|CAT:Best Coding:Best GUI:Best of All
					String[] split = str.split("#");
					String[] project = split[0].split(":");
					String[] cateria = split[1].split(":");
					for(int i = 1 ; i < project.length ; i++)
						mainController.getProjectList().add(new Project(Integer.parseInt(project[i].split(",")[0]), project[i].split(",")[1])); 
					for(int i = 1 ; i < cateria.length ; i++)
						mainController.getCateriaList().add(cateria[i]);
				}else if(tmp.equals("LOGI")){
					//LOGIN
					
				}else if(tmp.equals("LOGI")){
					//REGIS
					
				}else if(tmp.equals("LOGI")){
					//VOTE
					
				}
				
				out.flush();
			}
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			try{
				in.close();
				out.close();
				requestSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}
	
	public void sendMessage(String msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	
//	public static void main(String[] args) throws SocketException, ClassNotFoundException {
//		Requester client = new Requester();
//		client.run();
//	}
}