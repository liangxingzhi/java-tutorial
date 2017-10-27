package lxz.tutorial.java.fundamental;

public class ClassLoadAndInitialize {

  public static void main(String[] args) {
    A ab = new B();
    ab = new B();
  }
}

class A {

  static {
    System.out.print("1");
  }

  public A() {
    System.out.print("2");
  }
}

class B extends A {

  static {
    System.out.print("a");
  }

  public B() {
    super();
    System.out.print("b");
  }
}

