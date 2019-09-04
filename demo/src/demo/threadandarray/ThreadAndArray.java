package demo.threadandarray;

public class ThreadAndArray {

	private static int []inputs={100,32,11,1,4};
	private static int []outputs= {0,0,0,0,0};
	
	public static void main(String[] args) {
		ThreadDemo t=new ThreadDemo(inputs, outputs);
		for(int i=0;i<3;i++) {
			new Thread(t).start();
		}
		for(int i=0;i<outputs.length;i++){

		System.out.println("outputs["+i+"]£º"+outputs[i]);

		}
	}
}
