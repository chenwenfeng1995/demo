package demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Interrupt {

	public static void main(String[] args) {
		ExecutorService excutor =Executors.newCachedThreadPool();
		excutor.execute(()->{
			try {
				Thread.sleep(1000);
				System.out.println("thread run");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		excutor.shutdownNow();
		System.out.println("main run");
	}
}
