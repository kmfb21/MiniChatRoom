package com.bofang.chatclient.main;

import java.awt.EventQueue;

import com.bofang.chatclient.view.MainWindow;
import com.bofang.chatclient.main.ChatManager;

public class StartClient {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
					ChatManager.getChatManager().setWindow(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
