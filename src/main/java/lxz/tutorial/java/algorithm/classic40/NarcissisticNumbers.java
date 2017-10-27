package lxz.tutorial.java.algorithm.classic40;

/**
 * 题目：打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。
 *
 * 例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方
 */
public class NarcissisticNumbers {

  public static void main(String[] args) {
    for (int i = 1; i < 100000; i++) {
      if (isNarcissistic(i)) {
        System.out.println(i);
      }
    }
  }

  public static boolean isNarcissistic(int integer) {
    if (integer < 0) {
      throw new IllegalArgumentException("begin should be greater than 0");
    }
    int n = 0;
    while ((integer / (int) Math.pow(10, n)) > 0) {
      n++;
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      result += Math.pow((integer / (int) Math.pow(10, i)) % 10, n);
      if(i < n && result > integer) {
        break;
      }
    }
    return result == integer;
  }
}
