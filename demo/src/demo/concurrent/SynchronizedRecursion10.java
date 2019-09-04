package demo.concurrent;

public class SynchronizedRecursion10 {

	int a =0;
	public static void main(String[] args) {
		SynchronizedRecursion10 synchronizedRecursion10=new SynchronizedRecursion10();
		synchronizedRecursion10.method();
	}

	private synchronized void method() {
		// TODO Auto-generated method stub
		System.out.println(a);
		if(a==0) {
			a++;
			method();
		}
	}
}
