package lxz.tutorial.java.algorithm.classic40;

/**
 * 题目：求一个3*3矩阵对角线元素之和
 *
 * 1.程序分析：利用双重for循环控制输入二维数组，再将a[i][i]累加后输出。
 */
public class ArrayNumbers2 {

  public static void main(String[] args) {
    int sum = 0;
    int[][] ary = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    for(int i = 0; i < ary.length; i++) {
      sum += ary[i][i];
    }
    System.out.println(sum);
  }
}
