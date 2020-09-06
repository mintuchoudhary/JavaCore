package com.producerconsumerexample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
Java BlockingQueue interface is part of java collections framework and it’s primarily used for implementing 
producer consumer problem. 
We don’t need to worry about waiting for the
 space to be available for producer or 
object to be available for consumer in
 BlockingQueue because it’s handled by 
implementation classes of BlockingQueue.
*/
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
         //creating blocking queue of size 3
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
		Thread producerThread = new Thread(new Producer(queue));
		Thread consumerThread = new Thread(new Consumer(queue));

		producerThread.start();
		consumerThread.start();

	}
}
