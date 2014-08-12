package com.coinok.blockchain.testSocketIO;

import java.util.concurrent.ConcurrentHashMap;

import com.coinok.blockchain.testSocketIO.bean.LoginVo;
import com.corundumstudio.socketio.SocketIOClient;

public class GlobalClient {

	public static final ConcurrentHashMap<String, SocketIOClient> loginClients = new ConcurrentHashMap<String, SocketIOClient>();

	public static void login(SocketIOClient client, LoginVo login) {
		client.set("user_id", "0001");
		loginClients.put("0001", client);
	}

	public static void leave(SocketIOClient client) {
		String userid = client.get("user_id");
		if (userid != null && !userid.equals("")) {
			// SocketIOClient soclient = loginClients.get(userid);
			if (loginClients.get("0001") != null) {
				loginClients.remove(userid);
			}
		}
	}
}
