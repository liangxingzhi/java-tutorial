package lxz.tutorial.java.algorithm.classic40;

import java.util.Scanner;

/**
 * 【程序26】   题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续   判断第二个字母。
 */
public class GuessWeekDay {

  public static void main(String[] args) {
    System.out.println(guess(new Scanner(System.in)));
  }

  /**
   * Monday Tuesday Wednesday Thirsday Friday Saturday Sunday
   *
   * M Tu W Th F Sa Su
   */
  public static String guess(Scanner scanner) {
    System.out.println("please input a letter: ");
    char chr = scanner.next().charAt(0);
    if (Character.toUpperCase(chr) == 'M') {
      return "Monday";
    } else if (Character.toUpperCase(chr) == 'W') {
      return "Wednesday";
    } else if (Character.toUpperCase(chr) == 'F') {
      return "Friday";
    } else if (Character.toUpperCase(chr) == 'T') {
      System.out.println("please input another letter: ");
      chr = scanner.next().charAt(0);
      if (Character.toUpperCase(chr) == 'U') {
        return "Tuesday";
      } else if (Character.toUpperCase(chr) == 'H') {
        return "Thirsday";
      } else {
        return null;
      }

    } else if (Character.toUpperCase(chr) == 'S') {
      System.out.println("please input another letter: ");
      chr = scanner.next().charAt(0);
      if (Character.toUpperCase(chr) == 'A') {
        return "Saturday";
      } else if (Character.toUpperCase(chr) == 'U') {
        return "Sunday";
      } else {
        return null;
      }
    } else {
      return null;
    }
  }
}
