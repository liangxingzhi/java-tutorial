package lxz.tutorial.java.algorithm.classic40;

/**
 * 【程序17】   题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个
 *
 * 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下 的一半零一个。
 *
 * 到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
 */
public class MonkeyEatPeach {

  public static void main(String[] args) {

    System.out.println(count1(10));
    System.out.println(count2(10));
  }

  public static int count1(int days) {
    int sum = 1;
    for (int i = 1; i < days; i++) {
      sum = (sum + 1) * 2;
    }
    return sum;
  }

  public static int count2(int days) {
    if (days == 1) {
      return 1;
    } else {
      return (count2(days - 1) + 1) * 2;
    }
  }
}
