package lxz.tutorial.java.algorithm.classic40;

import java.util.Scanner;

public class CountDays {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("please input year : ");
    int year = scanner.nextInt();
    System.out.println("please input  month : ");
    int month = scanner.nextInt();
    System.out.println("please input day : ");
    int day = scanner.nextInt();

    int days = 0;
    int[] mdays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    for (int i = 0; i < month - 1; i++) {
      days += mdays[i];
    }
    if (month >= 3) {
      if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
        days += 1;
      }
    }
    days += day;
    System.out.println(year + "-" + month + "-" + day + ", days => " + days);
  }
}
