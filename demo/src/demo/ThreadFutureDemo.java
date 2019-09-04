package demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadFutureDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> f = new FutureTask<String>(new MyCallable());
		new Thread(f).start();
		if(!f.isDone()) {
			System.out.println("task has not finish,please wait");
		}
		System.out.println("finishi "+f.get());
	}

}
