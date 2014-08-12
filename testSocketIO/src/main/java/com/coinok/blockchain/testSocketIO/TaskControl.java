package com.coinok.blockchain.testSocketIO;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskControl {

	private static TaskControl instance;
	private static ScheduledExecutorService executorService;
	private static Set<BroadcastTask> tasks;

	private TaskControl() {
	};

	public synchronized static TaskControl getInstance() {

		if (instance == null) {
			instance = new TaskControl();
			executorService = Executors.newScheduledThreadPool(100);
			tasks = new HashSet<BroadcastTask>();
			tasks.add(new BroadcastTask(100, 100, TimeUnit.MILLISECONDS));
		}

		return instance;

	}

	public void start() {

		for (BroadcastTask bt : tasks) {
			executorService.scheduleWithFixedDelay(bt, bt.getInitialDelay(),
					bt.getDelay(), bt.getTimeUnit());
		}
	}

	public void stop() {

		executorService.shutdown();
		System.out.println("thread shutdown...........");
	}
}
