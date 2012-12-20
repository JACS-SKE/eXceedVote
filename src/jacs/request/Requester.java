package jacs.request;

import jacs.controller.MainController;
import jacs.controller.ServerController;
import jacs.domain.Criteria;
import jacs.domain.Project;
import jacs.domain.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author Jaturawit Jantarasriwongs
 * Class for connect to server by Socket
 */
public class Requester extends Observable{
	private Socket requestSocket;
	private ObjectOutputStream out;
 	private ObjectInputStream in;
 	private String message;
 	private int port = 9999;
 	private String ip = "192.168.1.46";
 	private ServerController serverController;
 	private MainController mainController;
 	
 	/**
 	 * 
 	 * @param serverController
 	 */
	public Requester(ServerController serverController){
		this.serverController = serverController;
		this.mainController = this.serverController.getMainController();
	}

	public void run() throws ClassNotFoundException{
		try{
			requestSocket = new Socket(ip, port);
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			while(true){
				String str = (String)in.readObject();
				//System.out.println(str);
				//String str = "INIT:1,name1:2,name2:3,name3:4,name4#CAT:Best Coding:Best GUI:Best of All";
				String tmp = str.substring(0, 4);
				if(tmp.equals("INIT")){
					//INIT -> ProjectList,Criteria
					//INIT:id1,name1:id2,name2:id3,name3:id4,name4#CRI:catID1,Best Coding:catID2,Best GUI:catID3,Best of All
					String[] split = str.split("#");
					String[] project = split[0].split(":");
					String[] cateria = split[1].split(":");
					for(int i = 1 ; i < project.length ; i++)
						mainController.getProjectList().add(new Project(Integer.parseInt(project[i].split(",")[0]), project[i].split(",")[1])); 
					for(int i = 1 ; i < cateria.length ; i++)
						mainController.getCriteriaList().add(new Criteria(Integer.parseInt(cateria[i].split(",")[0]), cateria[i].split(",")[1]));
				}else if(tmp.equals("LOGI")){
					//LOGIN (create user)
					String[] login = str.split(",");
						if(login[0].equals("LOGIN_FAILED")){
							//LOGIN_FAILED
							mainController.setLoginMsg(login[0]);
							this.setChanged();
							this.notifyObservers("LOGIN_FAILED");
						}else if(login[0].equals("LOGIN_SUCCESS")){
							//LOGIN_SUCCESS,name,type,point
							mainController.setLoginMsg(login[0]);
							mainController.setUser(new User(login[1], login[2], Integer.parseInt(login[3])));
							this.setChanged();
							this.notifyObservers("LOGIN_SUCCESS");
						}
				}else if(tmp.equals("REGIS")){
					//REGIS
					
				}else if(tmp.equals("VOTE")){
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
	
}