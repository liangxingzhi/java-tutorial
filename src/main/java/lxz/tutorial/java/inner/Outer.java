package lxz.tutorial.java.inner;

public class Outer {
	private int field1;
	static int field2;
	class Inner {
		public void dosth() {
			field1 = 10;
			field2 = 20;
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
