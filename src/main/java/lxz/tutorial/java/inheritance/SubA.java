package lxz.tutorial.java.inheritance;

public class SubA extends SuperA{
	
	@Override
	public synchronized void dosth() {
		System.out.println("SubA.this is " + this);
		super.dosth();
	}
	
	public static void main(String[] args) {
		SubA a = new SubA();
		a.dosth();
	}
}
