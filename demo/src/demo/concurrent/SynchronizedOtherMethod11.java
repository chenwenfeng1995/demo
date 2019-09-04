package demo.concurrent;

public class SynchronizedOtherMethod11 {

	public static void main(String[] args) {
		SynchronizedOtherMethod11 synchronizedOtherMethod11=new SynchronizedOtherMethod11();
		synchronizedOtherMethod11.method1();
	}

	private synchronized void method1() {
		// TODO Auto-generated method stub
		System.out.println("我是method1");
		method2();
	}

	private synchronized  void method2() {
		// TODO Auto-generated method stub
		System.out.println("我是method2");
	}
}
