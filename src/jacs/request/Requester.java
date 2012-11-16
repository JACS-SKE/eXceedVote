package jacs.request;


import jacs.controller.MainController;
import jacs.controller.ServerController;

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
			requestSocket = new Socket("192.168.1.34", port);
			System.out.println("Connected to localhost in port "+port);
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			while(true){
				String str = (String)in.readObject();
				if(str.equals("LOGIN_SUCCESS,test,student")){
					System.out.println("success");
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