package lxz.tutorial.java.concurrent;

import lxz.tutorial.java.util.UnsafeSupport;
import sun.misc.Unsafe;

public class UnsafeRelated {
  int a = 10;
  int b = 20;
  UnsafeRelated() {
    a = 10;
    b = 30;
  }
  public static void main(String[] args) {
    try {
      UnsafeRelated ur = (UnsafeRelated) UnsafeSupport.getUnsafe().allocateInstance(UnsafeRelated.class);
      System.out.println(ur + ":" + ur.a + ":" +ur.b);
    } catch (Exception e) {

    }
  }



}
