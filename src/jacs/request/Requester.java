package jacs.request;


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
 	
	public Requester(ServerController serverController){
		this.serverController = serverController;
	}

	public void run() throws ClassNotFoundException
	{
		try{
			requestSocket = new Socket("192.168.1.33", port);
			System.out.println("Connected to localhost in port "+port);
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
//			do{
//				try{
//					message = (String)in.readObject();
//					System.out.println("server > " + message);
//					sendMessage("Connected");
//				}
//				catch(ClassNotFoundException classNot){
//					System.err.println("data received in unknown format");
//				}catch(SocketException se){
//					System.out.println("Server Close");
//					break;
//				}
//			}while(!message.equals("bye"));
			
			do{
				List<String> list = serverController.getMainController().serverList;
				if(list.size() != 0){
					sendMessage(list.get(0));
					list.remove(0);
				}
			}while(true);
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