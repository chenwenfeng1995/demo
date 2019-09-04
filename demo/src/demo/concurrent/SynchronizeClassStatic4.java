package demo.concurrent;

public class SynchronizeClassStatic4 implements Runnable{

	static SynchronizeClassStatic4 instance1 =new SynchronizeClassStatic4();
	static SynchronizeClassStatic4 instance2 =new SynchronizeClassStatic4();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		method();
	}

	public static void main(String[] args) {
		Thread t1 =new Thread(instance1);
		Thread t2 =new Thread(instance2);
		t1.start();
		t2.start();
		while(t1.isAlive()||t2.isAlive()) {}
		System.out.println("finished");
	}
	public static synchronized void method() {
		System.out.println("类锁static形式"+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("结束"+Thread.currentThread().getName());
	}
}
