package com.coinok.blockchain.testSocketIO;

import com.alibaba.fastjson.JSON;
import com.coinok.blockchain.testSocketIO.bean.LoginVo;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.corundumstudio.socketio.annotation.OnMessage;

public class TransactionHandler {

	 @OnConnect
	 public void onConnect(SocketIOClient client) {
	
		System.out.println("onConnect............");
	 }
	 
	 @OnDisconnect
	 public void onDisconnect(SocketIOClient client) {
		 //client 会自动销毁吗
		 GlobalClient.leave(client);
		 System.out.println("onDisconnect............");
	 }
	 
	 

	 @OnEvent("news")
	 public void onLogin(SocketIOClient client,String data,AckRequest ackRequest){
		 //参数中的data 和ackrequest怎么对应前端
		 
		 System.out.println("onEvent(news)........");
		 LoginVo login = new LoginVo();
		 GlobalClient.login(client, login);
		// client.sendEvent("news", "new .....");
		 //client.sendEvent("aaa", data);
		// client.sendEvent("news", "newwww.");
		 client.set("isBinary", "false");
		// client.sendMessage("new listener client sendmessage");
		 
		 System.out.println("end running");
		 
		
	 }
}
