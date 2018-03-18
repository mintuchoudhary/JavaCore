package com.m2.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class CabServices implements Runnable {
	CyclicBarrier cyclicBarrier;

	CabServices(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		System.out.println("Passenger arrived: " + Thread.currentThread().getName());
		try {
			cyclicBarrier.await();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("Passenger boarded the cab:" + Thread.currentThread().getName());
	}
}

public class CyclicBarrierExample {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		/*
		 * If the specify more than 3 barriers then none passenger will board
		 * the cab unless all are accumulated. & if we specify 2 as barrier then
		 * all passenger will go in waiting state (await) but only 2 passenger
		 * will board the cab. Note: CyclicBarrier can be reused which is the
		 * main difference between CountDownLatch
		 */
		Thread t1 = new Thread(new CabServices(cyclicBarrier));
		t1.setName("Passenger 1");
		Thread t2 = new Thread(new CabServices(cyclicBarrier));
		t2.setName("Passenger 2");
		Thread t3 = new Thread(new CabServices(cyclicBarrier));
		t3.setName("Passenger 3");
		// Thread t4 = new Thread(new CabService(cyclicBarrier));
		t1.start();
		t2.start();
		t3.start();
		// t4.start();
	}
}
