package com.thread;

class NotifyThread extends Thread {
	MyResource resource;
	
	NotifyThread(MyResource resource)
	{
		this.resource=resource;
	}

	public void run() {
		synchronized (resource) {
		 
			resource.notify();
	//	 System.out.println(" after NotifyThread "+Thread.currentThread().getName());
		}
	}
}

class WaitThread extends Thread {
	MyResource resource;

	WaitThread(MyResource resource)
	{
		this.resource=resource;
	}
	
	public void run() {
		
		synchronized (resource) {
			try {
				System.out.println("WaitThread... "+Thread.currentThread().getName());
				resource.wait();
				System.out.println("notified "+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MyResource {

}

public class MyThreadWaitNotify {
	public static void main(String[] args) {
		MyResource resource = new MyResource();
		WaitThread thread1 = new WaitThread(resource);
		WaitThread thread2 = new WaitThread(resource);
		WaitThread thread3 = new WaitThread(resource);
		WaitThread thread4 = new WaitThread(resource);

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		NotifyThread nThread1= new NotifyThread(resource);
		nThread1.start();
		NotifyThread nThread2= new NotifyThread(resource);
		nThread2.start();
		NotifyThread nThread3= new NotifyThread(resource);
		nThread3.start();
		NotifyThread nThread4= new NotifyThread(resource);
		nThread4.start();
	/*
	 * Output:
	 *  WaitThread... Thread-2
		WaitThread... Thread-3
		WaitThread... Thread-0
		WaitThread... Thread-1
		notified Thread-2
		notified Thread-3
		notified Thread-0
		notified Thread-1
	 * 
	 * */
	
	}
}
