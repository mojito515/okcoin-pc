package com.coinok.blockchain.testSocketIO;

import java.io.InputStream;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

public class Server {

	public static SocketIOServer server;

	public void init() {
		System.out.println("init() in..........");
		final Configuration config = new Configuration();
		//config.setKeyStorePassword("");
		config.setPort(10119);
		config.setPreferDirectBuffer(false);
		server = new SocketIOServer(config);
		// BusinessHandler businessHandler = new BusinessHandler();
		TransactionHandler transactionHandler = new TransactionHandler();
		server.addListeners(transactionHandler);
		System.out.println("init() out..........");
	}

	public void start() {
		System.out.println("server start..........");
		server.start();
		
		TaskControl.getInstance().start();
	}

	public void stop() {
		server.stop();
		TaskControl.getInstance().stop();
	}
	
	public static void main(String[] args) {
		Server s = new Server();
		s.init();
		s.start();
	}

}
