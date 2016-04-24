package com.bofang.chatclient.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bofang.serversocket.ChatManager;

import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextArea txt;
	private JTextField ip;
	private JTextField send;
	private JButton btnSend;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txt = new JTextArea();
		txt.setText("Ready...");
		
		ip = new JTextField();
		ip.setText("127.0.0.1");
		ip.setColumns(10);
		
		JButton btnConnect = new JButton("Connect To Server");
		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChatManager.getChatManager().connect(ip.getText());
			}
		});
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		send = new JTextField();
		send.setText("Hello");
		send.setColumns(10);
		
		btnSend = new JButton("Send");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChatManager.getChatManager().send(send.getText());
				appendText("Me: "+send.getText());
				send.setText("");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(ip, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConnect))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(send, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSend))
						.addComponent(txt, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConnect))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txt, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(send, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSend)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void appendText(String in) {
		txt.append("\n"+in);
	}
}
