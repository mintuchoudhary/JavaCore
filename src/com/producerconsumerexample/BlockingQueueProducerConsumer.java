package com.m2.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
	BlockingQueue<Integer> queue;

	Producer(BlockingQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		int foodCnt = 0;
		while (true) {
			try {
			System.out.println(Thread.currentThread().getName() + " Produced : food" + foodCnt);
			queue.put(foodCnt++);
			
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

class Consumer implements Runnable {
	BlockingQueue<Integer> queue;

	Consumer(BlockingQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(Thread.currentThread().getName() + " Consumer : food" + queue.take());

				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class BlockingQueueProducerConsumer {
	public static void main(String[] args) {

		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
		Thread producerThread = new Thread(new Producer(queue));
		Thread consumerThread = new Thread(new Consumer(queue));

		producerThread.start();
		consumerThread.start();

	}
}