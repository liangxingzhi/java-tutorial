package lxz.tutorial.java.algorithm.classic40;

/**
 * 【程序11】   题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 */
public class ArrayOfNumbers {

  public static void main(String[] args) {
    fun(new int[]{1,2,3,4});
  }

  /**
   * @param ary , store numbers, no duplicate, [1,2,3,4]
   */
  public static void fun(int[] ary) {
    int count = 0;
    for (int i = 0; i < ary.length; i++) {
      for (int j = 0; j < ary.length; j++) {
        for (int k = 0; k < ary.length; k++) {
          if (ary[i] != ary[j] && ary[i] != ary[k] && ary[j] != ary[k]) {
            count++;
            System.out.println(ary[i] + "" + ary[j] + "" + ary[k]);
          }
        }
      }
    }
    System.out.println("count is => " + count);
  }
}
