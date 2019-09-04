package demo.threadandarray;

public class ThreadDemo implements Runnable{

	private int []inputs;
	private int []outputs;
	private boolean []a= {true,true,true,true,true};
	
	public ThreadDemo(int[] inputs, int[] outputs) {
		super();
		this.inputs = inputs;
		this.outputs = outputs;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++) {
			if(a[i]==true) {
			a[i]=false;
			for(int j=1;j<=inputs[i];j++) {
				outputs[i]+=j;
			}
			System.out.println(inputs[i]+Thread.currentThread().getName());
		}else {
			continue;
		}
		}
	}

}
