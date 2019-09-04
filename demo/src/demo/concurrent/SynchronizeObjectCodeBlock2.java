package demo.concurrent;

public class SynchronizeObjectCodeBlock2 implements Runnable{

	static SynchronizeObjectCodeBlock2 instance =new SynchronizeObjectCodeBlock2();
	Object lock1 =new Object();
	Object lock2 =new Object();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (lock1) {
		System.out.println("对象代码块1"+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("结束1"+Thread.currentThread().getName());
		}
		synchronized (lock2) {
			System.out.println("对象代码块2"+Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("结束2"+Thread.currentThread().getName());
			}
	}

	public static void main(String[] args) {
		Thread t1 =new Thread(instance);
		Thread t2 =new Thread(instance);
		t1.start();
		t2.start();
		while(t1.isAlive()||t2.isAlive()) {}
		System.out.println("finished");
	}
	
}
