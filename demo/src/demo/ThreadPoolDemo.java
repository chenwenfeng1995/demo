package demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadPoolDemo {

	public static void main(String[] args) throws ExecutionException {
		ExecutorService es=Executors.newCachedThreadPool();
		FutureTask<String> task= (FutureTask<String>) es.submit(new MyCallable());
		if(!task.isDone()) {
			System.out.println("please wait");
		}
		try {
			System.out.println("task is "+task.get());
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally {
			es.shutdown();
		}
	}
}
