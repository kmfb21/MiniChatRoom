package com.bofang.serversocket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatSocket extends Thread {
	
	Socket socket;
	
	public ChatSocket(Socket s) {
		this.socket = s;
	}
	
	public void out(String out) {
		try {
			socket.getOutputStream().write(out.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		int count = 0;
		while (true) {
			count++;
			out("loop: "+ count);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
