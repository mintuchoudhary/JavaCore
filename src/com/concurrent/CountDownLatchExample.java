package com.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

class CabService implements Runnable {
	CountDownLatch countDownLatch;

	CabService(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		
		try {
			System.out.println("Passenger arrived: " + Thread.currentThread().getName());
			Thread.sleep(1000);	
			
			countDownLatch.countDown();
			System.out.println("Passenger boarded the cab:" + Thread.currentThread().getName());
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

public class CountDownLatchExample  {
	public static void main(String[] args) throws Exception {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		Thread thread1 = new Thread(new CabService(countDownLatch));
		thread1.setName("Passenger 1");
		Thread thread2 = new Thread(new CabService(countDownLatch));
		thread2.setName("Passenger 2");
		Thread thread3 = new Thread(new CabService(countDownLatch));
		thread3.setName("Passenger 3");
		thread1.start();
		thread2.start();
		thread3.start();
		
		countDownLatch.await();
		System.out.println("Main : Now the cab is moving : "+Thread.currentThread().getName());
		
	}
}
/*
Output:
Passenger arrived: Passenger 3
Passenger arrived: Passenger 2
Passenger arrived: Passenger 1
Passenger boarded the cab:Passenger 2
Passenger boarded the cab:Passenger 3
Passenger boarded the cab:Passenger 1
Main : Now the cab is moving : main

*/
