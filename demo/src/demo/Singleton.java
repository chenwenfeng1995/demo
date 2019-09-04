package demo;

public class Singleton {

	private static Singleton single;
	public Singleton() {}
	public static Singleton getInstance() {
		if(single==null) {
			synchronized (Singleton.class) {
				if(single==null) {
					single=new Singleton();
				}
			}
		}
		return single;
	}
    
}
