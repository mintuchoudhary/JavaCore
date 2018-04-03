package com.atomicvariables;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * To solve this issue, we will have to make sure that increment operation on count is atomic, 
 * we can do that using Synchronization but Java 5 java.util.concurrent.atomic 
 * provides wrapper classes for int and long that can be used to achieve this atomic
 *  operation without usage of Synchronization.
 * */
public class JavaAtomic {

	public static void main(String[] args) throws InterruptedException {

		ProcessingThread pt = new ProcessingThread();
		Thread t1 = new Thread(pt, "t1");
		t1.start();
		Thread t2 = new Thread(pt, "t2");
		t2.start();
		 t1.join();
		 t2.join();
		System.out.println("Processing count=" + pt.getCount());
	}

}

class ProcessingThread implements Runnable {
	  //private int count;
	  private AtomicInteger count = new AtomicInteger();
	  
	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+" count = "+count);
			
			/*try {
				System.out.println(Thread.currentThread().getName()+" count = "+count);
				Thread.sleep(i * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		
			//count++;
			count.incrementAndGet();
		}
	}

	public int getCount() {
		//return this.count;
		return this.count.get();
	}

}