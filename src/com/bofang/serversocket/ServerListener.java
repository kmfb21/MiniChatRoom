package com.bofang.serversocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {

	@Override
	public void run() {
		try {
			//port: 1-65535
			ServerSocket serverSocket = new ServerSocket(12345);
			while (true) {
				//will block current thread
				Socket socket = serverSocket.accept();
				//if connected:
				JOptionPane.showMessageDialog(null, "one client conneted to port 12345");
				
				//pass socket to a new thread
				ChatSocket cs = new ChatSocket(socket);
				cs.start();
				//and add to general manager
				ChatManager.getChatManager().add(cs);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
