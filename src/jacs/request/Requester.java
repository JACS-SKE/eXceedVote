package jacs.request;


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
 	int port = 9999;
 	Scanner sc;
 	
	public Requester(){
		sc = new Scanner(System.in);
	}
	
	public void run() throws ClassNotFoundException
	{
		try{
			requestSocket = new Socket("192.168.1.42", port);
			System.out.println("Connected to localhost in port "+port);
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			do{
				try{
					message = (String)in.readObject();
					System.out.println("server > " + message);
					sendMessage("test form nooh");
				}
				catch(ClassNotFoundException classNot){
					System.err.println("data received in unknown format");
				}catch(SocketException se){
					System.out.println("SERVER CLOSE");
					break;
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
	
	public static void main(String[] args) throws SocketException, ClassNotFoundException {
		Requester client = new Requester();
		client.run();
	}
}