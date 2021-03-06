package com.bofang.serversocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread {

	Socket socket;

	public ChatSocket(Socket s) {
		this.socket = s;
	}

	public void out(String out) {
		try {
			socket.getOutputStream().write((out+"\n").getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		out("You have connect to our server!");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			String line = null;
			while ((line = br.readLine())!=null) {
				ChatManager.getChatManager().publish(this, line);
			}
			br.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
