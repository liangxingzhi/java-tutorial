package lxz.tutorial.java.algorithm.classic40;

/**
 * 【程序2】   题目：判断101-200之间有多少个素数，并输出所有素数。
 *
 * 1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，
 *
 * 则表明此数不是素数，反之是素数。
 */
public class PrimeNumbers {

  public static void main(String[] args) {
    int count = 0;
    for (int i = 2; i <= 100; i++) {
      if (isPrime(i)) {
        count++;
        System.out.println(i);
      }
    }
    System.out.println(count);
  }

  public static boolean isPrime(int integer) {
    if (integer < 1) {
      throw new IllegalArgumentException("begin should be greater than 0");
    }
    for (int i = 2; i <= integer / 2; i++) {
      if (integer % i == 0) {
//        System.out.println(integer + " % " + i + " == 0");
        return false;
      }
    }
    return true;
  }
}
