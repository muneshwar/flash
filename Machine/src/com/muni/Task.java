package com.muni;

public class Task {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable task = ()->{
			System.out.println("current thread name :"+Thread.currentThread().getName());
		};
		
		task.run();
		
		Thread robo = new Thread(task);
		robo.start();
		System.out.println("Program has been ended!!");
	}

}
