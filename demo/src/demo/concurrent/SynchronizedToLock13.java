package demo.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedToLock13 {

	Lock lock=new ReentrantLock();
	
	public synchronized void method1() {
		System.out.println("synchronized��ʽ��");
	}
	public void method2() {
		lock.lock();
		try {
			System.out.println("lock��ʽ��");
		}finally{
			lock.unlock();
		}
	}
	public static void main(String[] args) {
		SynchronizedToLock13 synchronizedToLock13=new SynchronizedToLock13();
		synchronizedToLock13.method1();
		synchronizedToLock13.method2();
	}
}
