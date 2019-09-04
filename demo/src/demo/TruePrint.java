package demo;


public class TruePrint {

	float x=1;
	public void A() {
		x=55;
	}
	public void B(TruePrint object) {
		object.x=10;
	}
	
	public static void main(String[] args) {
		TruePrint a=new TruePrint();
		TruePrint b=new TruePrint();
		a.A();
		a.B(b);
		System.out.println(a.x);
		System.out.println(b.x);
	}
}
