package modele.technique.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import controleur.ManetteTCP;

public class Serveur implements Runnable {
	
	 private static Socket socket;
	 private static ServerSocket serveur;
	 private static InputStreamReader isr;
	 private static BufferedReader br;
	 private static String message;
	 private Thread th;
	 private ManetteTCP manette;
	 
	 public Serveur(int port) {
		 
		 try {
			 th = new Thread(this);
			 serveur = new ServerSocket(port);
			 
		 }catch(IOException e){
			 e.printStackTrace();
		 }
	 }

	@Override
	public void run() {
		while(true) {
			try {
				socket = serveur.accept();
				isr = new InputStreamReader(socket.getInputStream());
				br = new BufferedReader(isr);
				message = br.readLine();
				//manette.recuperation(message);
				System.out.println(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void go() {
		th.start();
	}
}
