package lxz.tutorial.java.algorithm.classic40;

/**
 *
 */
public class Factorial {

  public static void main(String[] args) {
    int[] bigint = new int[200];
    bigint[bigint.length - 1] = 1;
    for (int i = 1; i <= 100; i++) {
      bigint = multiply(bigint, i);
    }

    System.out.println("-------------------------");

    simpleMulti();

    System.out.println("-------------------------");

    System.out.println(factor(5));
  }

  public static int[] multiply(int[] ary, int multi) {
    int progress = 0;
    for (int i = ary.length - 1; i >= 0; i--) {
      int tmp = (ary[i] * multi + progress);
      ary[i] = tmp % 10;
      progress = tmp / 10;
    }
    print(ary);
    return ary;
  }

  public static void print(int[] bigint) {
    for (int i = 0; i < bigint.length; i++) {
      System.out.print(bigint[i]);
    }
    System.out.println();
  }

  /**
   * 20 is the limit for type long
   */
  public static void simpleMulti() {
    long sum = 0;
    long fac = 1;
    for (int i = 1; i <= 20; i++) {
      fac = fac * i;
      sum += fac;
      System.out.println(fac);
    }
    System.out.println(sum);
  }

  public static long factor(int n) {
    if (n == 1) {
      return 1;
    } else {
      return n * factor(n - 1);
    }

  }
}
