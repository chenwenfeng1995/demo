package demo.concurrent;

class TestClass1 {

	public synchronized void dosomething() {
		System.out.println("���Ǹ���");
	}
}

public class TestClass extends TestClass1{
	public synchronized void dosomething() {
		System.out.println("��������");
		super.dosomething();
	}
	public static void main(String[] args) {
		TestClass test=new TestClass();
		test.dosomething();
	}
}
