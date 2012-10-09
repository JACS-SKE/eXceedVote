package com.jacs.request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Requester{
	Socket requestSocket;
	ObjectOutputStream out;
 	ObjectInputStream in;
 	String message;
 	int port = 2555;
 	Scanner sc;
 	
	public Requester(){
		sc = new Scanner(System.in);
	}
	
	public void run() throws ClassNotFoundException
	{
		try{
			//1. creating a socket to connect to the server
			requestSocket = new Socket("192.168.1.48", port);
			System.out.println("Connected to localhost in port "+port);
			//2. get Input and Output streams
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			//3: Communicating with the server
			do{
				try{
					message = (String)in.readObject();
					System.out.println("server > " + message);
					System.out.print("Msg > ");
					sendMessage(sc.nextLine());
				}
				catch(ClassNotFoundException classNot){
					System.err.println("data received in unknown format");
				}catch(SocketException se){
					System.out.println("SERVER CLOSE");
				}
			}while(!message.equals("bye"));
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
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
			//System.out.println("client > " + msg);
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