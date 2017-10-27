package lxz.tutorial.java.algorithm.classic40;

import java.util.Scanner;

/**
 * 题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，
 *
 * 问最后留下的是原来第几号的那位。
 */
public class ThreeOut {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please input the total number of person : ");
    int n = scanner.nextInt();
    boolean[] narray = new boolean[n];
    int i = 1;

    boolean isFinish = false;
    while (!isFinish) {
      for (int j = 0; j < narray.length; j++) {
        if (!narray[j]) {
          if (i % 3 == 0) {
            narray[j] = true;
            if (i == 3 * (n - 1)) {
              isFinish = true;
              break;
            }
          }
          i++;
        } else {
          continue;
        }
      }
    }
    for (int j = 0; j < narray.length; j++) {
      if (!narray[j]) {
        System.out.println("The last one is " + (j + 1));
      }
    }


  }


}
