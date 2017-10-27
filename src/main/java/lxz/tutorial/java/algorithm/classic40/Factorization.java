package lxz.tutorial.java.algorithm.classic40;

/**
 * 【程序4】   题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
 */
public class Factorization {

  public static void main(String[] args) {
    for (int i = 1; i <= 100; i++) {
      System.out.println(i + " = " + factor(i));
      System.out.println(i + " = " + factor2(i));
    }

  }

  public static String factor(int input) {
    if (input < 1) {
      throw new IllegalArgumentException("Input is not valid, must greater than 0");
    }
    if (input == 1) {
      return "1";
    }

    for (int i = 2; i <= input; i++) {
      if (!PrimeNumbers.isPrime(i)) {
        continue;
      }
      if (input == i) {
        return "" + i;
      } else if (input % i == 0) {
        return i + " * " + factor(input / i);
      }
    }
    return null;
  }

  public static String factor2(int input) {
    if (input < 1) {
      throw new IllegalArgumentException("Input is not valid, must greater than 0");
    }
    for (int i = 2; i <= input / 2; i++) {
      if (input % i == 0) {
        return i + " * " + factor2(input / i);
      }
    }
    return input + "";
  }
}
