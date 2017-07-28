package lxz.tutorial.java.inner;

public class Outer {
	class Inner {
		public void dosth() {
			System.out.println(Outer.this);
		}
	}
	
	public static void main(String[] args) {
		Outer o = new Outer();
		Inner e = o.new Inner();
		e.dosth();
		System.out.println(e);
	}
}
