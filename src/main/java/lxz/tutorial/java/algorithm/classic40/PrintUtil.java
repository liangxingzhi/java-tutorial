package lxz.tutorial.java.algorithm.classic40;

public class PrintUtil {

  public static void print(int[] ary) {
    for (int i = 0; i < ary.length; i++) {
      if (i != ary.length-1) {
        System.out.printf("%3d,", ary[i]);
      } else {
        System.out.printf("%3d", ary[i]);
      }
    }
    System.out.println();
  }
}
