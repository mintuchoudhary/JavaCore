package com.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class WorkerThread implements Runnable {

	private String command;

	public WorkerThread(String s) {
		this.command = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start of worker = " + command);
		try {
			Thread.sleep(5000);
			
			System.out.println(Thread.currentThread().getName() + " End.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

/*class ThreadByCallable implements Callable<String>
{

	@Override
	public String call() throws Exception {
      System.out.println("in call method of Callable ");
		return Thread.currentThread().getName();
	}
	
}*/

/*
 *  In above program, we are creating fixed size thread pool of 5 worker threads.
 *  Then we are submitting 10 jobs to this pool, since the pool size is 5, 
 *  it will start working on 5 jobs and other jobs will be in wait state, 
 *  as soon as one of the job is finished, 
 *  another job from the wait queue will be picked up by worker thread and get's executed.
 * */

public class ThreadPoolByExecutorService {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		//ThreadByCallable thread = new ThreadByCallable();
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread("" + i);
			executor.execute(worker);
		//  executor.submit(worker); //execute() and submit() both will work for Runnable
		}
	//	executor.submit(thread);  // only submit works for Callable
		executor.shutdown();

	}
}
