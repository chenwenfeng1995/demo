package demo.concurrent;

public class SynchronizedException9 implements Runnable{

	static SynchronizedException9 instance =new SynchronizedException9();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(Thread.currentThread().getName().equals("Thread-0")) {
			method1();
		}else {
			method2();
		}
	}

	public synchronized void method1() {
		System.out.println("method1"+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
			throw new Exception();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
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
