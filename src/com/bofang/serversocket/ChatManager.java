package com.bofang.serversocket;

import java.util.Vector;

import com.bofang.chatclient.view.MainWindow;

public class ChatManager {
	private ChatManager(){}
	private static final ChatManager cm = new ChatManager();
	public static ChatManager getChatManager() {
		return cm;
	}
	
	Vector<ChatSocket> vector = new Vector<ChatSocket>();
	
	public void add(ChatSocket cs) {
		vector.add(cs);
	}
	public void publish(ChatSocket cs, String out) {
		for (int i = 0; i < vector.size(); i++) {
			ChatSocket csChatSocket = vector.get(i);
			if (!cs.equals(csChatSocket)) {
				csChatSocket.out(out);
			}
		}
	}
	
	MainWindow window;
	public void setWindow(MainWindow window) {
		this.window = window;
		window.appendText("Window binded with Class: ChatManager");
	}
	
	public void connect(String ip) {
		
	}
	public void send(String out) {
		
	}
}
