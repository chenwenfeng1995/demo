package demo;

import java.util.concurrent.locks.ReentrantLock;

public class SleepAndWait {

	public static void main(String[] args) {
		ReentrantLock lock =new ReentrantLock();
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("A is waiting to lock");
				synchronized (lock) {
					System.out.println("A1");
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("A2");
					try {
						lock.wait(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("A3");
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("B is waiting to lock");
				synchronized (lock) {
					System.out.println("B1");
					System.out.println("B2");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("B3");
				}
			}
			
		}).start();
	}
}
