package com.java8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/*
This method demonstrate that 3 cyclic barrier are 3 person which are acting as threads and will wait for each other 3 to come together and
then the barrier will be broken n all can move ahead in same car.
*/
class CabService implements Runnable {
	CyclicBarrier cyclicBarrier;

	CabService(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " boarded the cab");
			Thread.sleep(2000);
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cab is moving now with "+ Thread.currentThread().getName());
	}
}

public class CyclicBarrierExample {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

		Thread p1 = new Thread(new CabService(cyclicBarrier));
		p1.setName("Passenger 1");
		Thread p2 = new Thread(new CabService(cyclicBarrier));
		p2.setName("Passenger 2");
		Thread p3 = new Thread(new CabService(cyclicBarrier));
		p3.setName("Passenger 3");

		p1.start();
		p2.start();
		p3.start();
	}
}
