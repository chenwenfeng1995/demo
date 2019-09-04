package demo.concurrent;

import javax.sql.rowset.Joinable;

public class DisppearRequest1 implements Runnable{

	static DisppearRequest1 request =new DisppearRequest1();
	
	static int i=0;
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		for ( int j=0; j < 100000; j++) {
			i++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(request);
		Thread t2=new Thread(request);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
}
