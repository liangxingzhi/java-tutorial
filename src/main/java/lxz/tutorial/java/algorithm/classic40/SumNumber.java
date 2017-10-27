package lxz.tutorial.java.algorithm.classic40;

import java.util.Scanner;

/**
 * 2 + 22 + 222 + 2222
 */
public class SumNumber {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("please input a number (1-9) ");
    int input = scanner.nextInt();
    System.out.println("please input a number times ");
    int times = scanner.nextInt();
    sum(input, times);
    sum2(input, times);

  }

  public static void sum(int input, int times) {
    int result = 0;
    int param = input;
    for (int i = 1; i <= times; i++) {
      result += param;
      param = input + param * 10;
    }

    System.out.println("param => " + param + ", result => " + result);
  }

  public static void sum2(int input, int times) {
    int result = 0;
    String param = "";
    for (int i = 1; i <= times; i++) {
      param = param + input;
      result += Integer.parseInt(param);
    }

    System.out.println("param => " + param + ", result => " + result);
  }
}
