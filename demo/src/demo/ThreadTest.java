package demo;

public class ThreadTest {
	public static  void attack() {
		System.out.println("fight");
		System.out.println("current thread is"+Thread.currentThread().getName());
	}
	public static void main(String[]args) {
		Thread t =new Thread() {
			public void run(){
				attack();
			}
		};
		System.out.println("current main thread is"+Thread.currentThread().getName());
		t.start();
	}

}
