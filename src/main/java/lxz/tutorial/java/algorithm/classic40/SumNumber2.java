package lxz.tutorial.java.algorithm.classic40;

/**
 * //  【程序20】   题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
 */
public class SumNumber2 {

  public static void main(String[] args) {
    sum1(20);
    sum2(20);
  }

  public static void sum2(int n) {
    double fm = 1;
    double fz = 1;
    double sum = 0;
    double tmp = 0;
    for (int i = 1; i <= n; i++) {
      tmp = fz;
      fz = fz + fm;
      fm = tmp;
      sum += fz / fm;
    }
    System.out.println(sum);
  }

  public static void sum1(int n) {
    double sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += fibonacci(i + 1) / (double) fibonacci(i);
    }
    System.out.println(sum);
  }

  public static int fibonacci(int n) {
    if (n == 1 || n == 2) {
      return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }


}
