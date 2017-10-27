package lxz.tutorial.java.algorithm.classic40;

import java.util.Scanner;

public class OrderNumbers {

  public static void main(String[] args) {
    int i, j, k, x;
    Scanner scanner = new Scanner(System.in);
    System.out.println("input first:");
    i = scanner.nextInt();
    System.out.println("input second:");
    j = scanner.nextInt();
    System.out.println("input third:");
    k = scanner.nextInt();

    if (i > j) {
      x = i;
      i = j;
      j = x;
    }
    if (i > k) {
      x = i;
      i = k;
      k = x;
    }
    if (j > k) {
      x = j;
      j = k;
      k = x;
    }

    System.out.println("The ordered numbers is : " + i + " " + j + " " + k);
  }
}
