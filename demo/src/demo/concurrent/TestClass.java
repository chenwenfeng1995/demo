package demo.concurrent;

class TestClass1 {

	public synchronized void dosomething() {
		System.out.println("我是父类");
	}
}

public class TestClass extends TestClass1{
	public synchronized void dosomething() {
		System.out.println("我是子类");
		super.dosomething();
	}
	public static void main(String[] args) {
		TestClass test=new TestClass();
		test.dosomething();
	}
}
