package demo.concurrent;

import demo.SleepAndWait;

public class SynchronizeObjectMethod3 implements Runnable{

	static SynchronizeObjectMethod3 instance =new SynchronizeObjectMethod3();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 method();
	}

	public static void main(String[] args) {
		Thread t1=new Thread(instance);
		Thread t2=new Thread(instance);
		t1.start();
		t2.start();
		while(t1.isAlive()||t2.isAlive()) {}
		System.out.println("finished");
	}
	
	public synchronized void method() {
		System.out.println("方法修饰符形式"+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("结束"+Thread.currentThread().getName());
	}
}
