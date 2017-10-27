package lxz.tutorial.java.algorithm.classic40;

/**
 * http://www.cnblogs.com/gxbk629/p/3587562.html
 *
 * 古典问题:有一对兔子;从出生后第3个月起每个月都生一对兔子， 小兔子长到第三个月后每个月又生一对兔子，
 *
 * 假如兔子都不死，两年后， 问每个月的兔子总数是多少？
 *
 * 用for循环实现，提示:每月兔子对数为:1.1.2.3.5.8.13.21.34.55 </p>
 */
//
// --------------------------------------------------------
// 每个月的兔子对数，都等于前两个月的和
//            1  1  2  3  5  8  13 21
//-----------------------------------------
// age/month  1  2  3  4  5  6  7  8
//          1 1     1  1  2  3  5  8
//          2    1     1  1  2  3  5
//          3       1     1  1  2  3
//          4          1     1  1  2
//          5             1     1  1
//          6                1     1
//          7                   1
//          8                      1

public class RabbitCount {

  public static void main(String[] args) {
    for (int i = 1; i < 1000; i++) {
      System.out.println("month [" + i + "] -> " + count(i));
    }
  }

  /**
   *
   * @param month
   * @return
   */
  public static int count(int month) {
    if (month < 1) {
      throw new IllegalArgumentException("month should be greater than 0");
    }
    if (month == 1 || month == 2) {
      return 1;
    } else {
      return count(month - 1) + count(month - 2);
    }
  }
}
