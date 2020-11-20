package com.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*submit() - returns a Future method - which as isDone() method
Future - has get() method to get the result
execute() - returns a void*/

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
 
 newFixedThreadPool      - creates a pool with fixed number of thread given
 newSingleThreadExecutor - Single thread will be responsible for executing all 10 jobs.
 newCachedThreadPool     - creates a thread pool that creates new thread as needed, but will reuse 
                           previous constructed thread when they are available
newScheduledThreadPool   - when you want to execute a task after a period of time or periodically			   
 * */

public class ThreadPoolByExecutorService {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		//ExecutorService executor = Executors.newSingleThreadExecutor(); //create a single thread pool
		//ExecutorService executor = Executors.newCachedThreadPool();
		//ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
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
