package com.bofang.chatclient.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import com.bofang.chatclient.view.MainWindow;

public class ChatManager {
	private ChatManager(){}
	private static final ChatManager cm = new ChatManager();
	public static ChatManager getChatManager() {
		return cm;
	}
	
	MainWindow window;
	Socket socket;
	BufferedReader reader;
	PrintWriter writer;
	
	public void setWindow(MainWindow window) {
		this.window = window;
		window.appendText("Window binded with Class: ChatManager");
	}
	
	public void connect(String ip) {
		new Thread(){
			@Override
			public void run() {
				try {
					socket = new Socket(ip, 12345);
					writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
					reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
					String line;
					while ((line=reader.readLine())!=null) {
						window.appendText("Message get: "+line);
					}
					writer.close();
					reader.close();
					writer = null;
					reader = null;
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	public void send(String out) {
		if (writer!=null) {
			writer.write(out+"\n");
			writer.flush();
		} else {
			window.appendText("connect break");
		}
	}
}
