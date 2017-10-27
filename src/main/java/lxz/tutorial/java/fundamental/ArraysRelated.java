package lxz.tutorial.java.fundamental;

import java.lang.reflect.Field;
import java.util.Arrays;
import org.springframework.util.Assert;

public class ArraysRelated {

  public static void main(String[] args) {
    ArraysRelated ar = new ArraysRelated();
    ar.copy();
    int[] a = new int[4];
    int[] b = new int[5];
    Integer[] c = new Integer[6];
    Long[] d = new Long[7];
    System.out.println(a.getClass());
    System.out.println(b.getClass());
    System.out.println(c.getClass());
    System.out.println(d.getClass());
    System.out.println(a.getClass() == b.getClass());
    for (Field m : a.getClass().getDeclaredFields()) {
      System.out.println(m);
    }

    testArrayRef();
  }

  public static void testArrayRef() {
    System.out.println();
    Super[] supers = new Son[10];
    System.out.println(supers instanceof Super[]);
    System.out.println(supers instanceof Son[]);
    System.out.println(supers.getClass().getSuperclass());
    System.out.println(supers.getClass().getInterfaces());
    testArrayRef2(new Son[10]);

    System.out.println("Super[] is assignable from Son[]"+ Super[].class.isAssignableFrom(Son[].class));

  }

  public static void testArrayRef2(Super[] supers) {
  }

  private void copy() {
    int[] a = {1, 2, 3};
    int[] c = Arrays.copyOf(a, a.length);
    Assert.isTrue(a != c, "a 和 c 必须不同");

    Object[] aryFrom = {new Object(), new Object(), new Object()};
    Object[] aryTo = Arrays.copyOf(aryFrom, aryFrom.length);

    Assert.isTrue(System.identityHashCode(aryFrom[0]) == System.identityHashCode(aryTo[0]),
        "数组复制后对象不被复制，而仅仅是引用复制");

  }

  static class Super {

  }

  static class Son extends Super {

  }

}
