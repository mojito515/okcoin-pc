package com.coinok.blockchain.testSocketIO;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import com.corundumstudio.socketio.SocketIOClient;

public class BroadcastTask implements Runnable {

	protected long initialDelay;
	protected long delay;
	protected TimeUnit timeUnit;
	
	public BroadcastTask(long initialDelay, long delay, TimeUnit timeUnit) {
		super();
		this.initialDelay = initialDelay;
		this.delay = delay;
		this.timeUnit = timeUnit;
	}
	public long getDelay() {
		return delay;
	}
	public void setDelay(long delay) {
		this.delay = delay;
	}
	public TimeUnit getTimeUnit() {
		return timeUnit;
	}
	public void setTimeUnit(TimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}
	public long getInitialDelay() {
		return initialDelay;
	}
	public void setInitialDelay(long initialDelay) {
		this.initialDelay = initialDelay;
	}
	
	public Map<String,Object> getData(){
		//search redis and collect the data
		
		return null;
	}
	public void run() {
		//System.out.println("in thread's run method");
		ConcurrentHashMap<String, SocketIOClient> clients = GlobalClient.loginClients;
		for(SocketIOClient client:clients.values()){
			client.set("isBinary", "false");
			String eventName = "mojito";
			String message = "mojito's args";
			String content = String.format(
					"{\"name\":\"%s\",\"args\":[\"%s\"]}", eventName, message);
			client.sendMessage(content);
		}
		
	}
	

}
