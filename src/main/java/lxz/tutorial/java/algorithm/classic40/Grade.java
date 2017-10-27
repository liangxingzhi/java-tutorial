package lxz.tutorial.java.algorithm.classic40;

import java.util.Scanner;

/**
 * 【程序5】   题目：利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
 */
public class Grade {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please input the score : ");
    int score = scanner.nextInt();
    System.out.println(score + " is " + grade(score));
  }

  public static String grade(int score) {
    return score >= 90 ? "A" : (score < 60 ? "C" : "B");
  }
}
