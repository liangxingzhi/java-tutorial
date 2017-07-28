package lxz.tutorial.java.concurrent;

public class ThreadLocalRelated {
	
	public static void main(String[] args) {
		ThreadLocal<Integer> a = new ThreadLocal<>();
		a.set(10);
		System.out.println(a.get());
		
		ThreadLocal<Integer> b = new ThreadLocal<>();
		b.set(20);
		System.out.println(b.get());
		
	}
}
