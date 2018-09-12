package com.muni;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Executor {
	public static void main(String[] args) throws InterruptedException,ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(
		()->{
			System.out.println("current thread"+Thread.currentThread().getName());
		}		
				);
	
		// Shutting down the executor services
		executor.shutdown();
		executor.awaitTermination(5, TimeUnit.SECONDS);
		
		// Callable Usage
		Callable<Integer> callableTask = () -> {
			return new Random().nextInt(100);
		};
		ExecutorService callableExecutor = Executors.newFixedThreadPool(1);
		Future<Integer> future = callableExecutor.submit(callableTask);
		System.out.println("Future is done : "+future.isDone());
		callableExecutor.shutdownNow();
		Integer result = future.get();
		System.out.println("Integer value is : "+result);
		System.out.println("Future is done : "+future.isDone());

		// Schedule executor service
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		Runnable task = ()->System.out.println("time : "+System.nanoTime());
		scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
	}

}
