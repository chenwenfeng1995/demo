package demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MainDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Thread thread =new Thread(new MyThread());
		thread.start();
		Thread runnable =new Thread(new MyRunnable());
		runnable.start();
		FutureTask<String> task=new FutureTask<>(new MyCallable());
		Thread callable = new Thread(task);
		callable.start();
		System.out.println(task.get());
		ExecutorService taskpool=Executors.newCachedThreadPool();
		FutureTask<String> callblePool =(FutureTask<String>) taskpool.submit(new MyCallable());
		System.out.println(callblePool.get());
		taskpool.shutdown();
	}

}
