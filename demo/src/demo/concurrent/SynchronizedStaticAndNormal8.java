package demo.concurrent;

public class SynchronizedStaticAndNormal8 implements Runnable{

	static SynchronizedStaticAndNormal8 instance =new SynchronizedStaticAndNormal8();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(Thread.currentThread().getName().equals("Thread-0")) {
			method1();
		}else {
			method2();
		}
	}

	public synchronized static void method1() {
		System.out.println("method1"+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("method1½áÊø"+Thread.currentThread().getName());
	}
    public synchronized void method2() {
    	System.out.println("method2"+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("method2½áÊø"+Thread.currentThread().getName());
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
