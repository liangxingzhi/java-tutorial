package lxz.tutorial.java.fundamental;

public class CodeBlock {
	int a;
	{
		System.out.println("a init block before: " + a);
		a = 1;
		System.out.println("a init block after: " + a);
	}

	{
		System.out.println("a init block before: " + a);
		a = 3;
		System.out.println("a init block after: " + a);
	}

	static int b;
	static {
		System.out.println("b static init block before: " + b);
		b = 2;
		System.out.println("b static init block after: " + b);
	}

	CodeBlock() {
		System.out.println("a construct block before: " + a);
		a = 2;
		System.out.println("a construct block after: " + a);
	}

	public static void main(String[] args) {
		CodeBlock b = new CodeBlock();
		b = new CodeBlock();
	}
}
