package lxz.tutorial.java.algorithm.classic40;

/**
 * 　　【程序24】   题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
 */
public class IntegerDigit {

  public static void main(String[] args) {
    guessDigit(23435);
  }

  public static void guessDigit(int number) {
    int i = 0;
    while (number / 10 > 0) {
      System.out.print(number % 10);
      number = number / 10;
      i++;
    }
    i++;
    System.out.println(number);
    System.out.println(i);
  }

}
