package lxz.tutorial.java.interview.guessnumbers;

public final class Pair implements Comparable<Pair> {
	private final int sum;
	private final int multiply;
	private final int x;
	private final int y;
	public Pair(int i, int j) {
		if (i > j) {
			int tmp = i;
			i = j;
			j = tmp;
		}
		x = i;
		y = j;
		sum = i + j;
		multiply = i * j;
		
	}
	public int sum() {
		return sum;
	}
	public int multiply() {
		return multiply;
	}
	
	@Override
	public boolean equals(Object obj) {
		Pair p = (Pair) obj;
		return this.x == p.x && this.y == p.y;
	}
	
	@Override
	public int hashCode() {
		return getPower();
	}

	@Override
	public int compareTo(Pair o) {
		return this.getPower() - o.getPower();
	}

	private int getPower() {
		return x * 10001 + y;
	}
	
	@Override
	public String toString() {
		return "[" + x + " , " + y + "]";
	}
}