package demo;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "my callable";
	}

}
