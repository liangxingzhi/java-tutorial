package lxz.tutorial.java.algorithm.classic40;

//    1
//
//    1   1
//
//    1   2   1
//
//    1   3   3   1
//
//    1   4   6   4   1
//
//    1   5   10   10   5   1

/**
 * 题目：打印出杨辉三角形（要求打印出10行如下图）
 */
public class YangHuiTriangle {

  public static void main(String[] args) {
    int[] result = null;
    for (int i = 0; i < 5; i++) {
      result = next(result);
      PrintUtil.print(result);
    }
  }

  public static int[] next(int[] lastRow) {
    if (lastRow == null) {
      return new int[]{1};
    } else if (lastRow.length == 1) {
      return new int[]{1, 1};
    }
    int[] result = new int[lastRow.length + 1];
    result[0] = 1;
    for (int i = 1; i < lastRow.length; i++) {
      result[i] = lastRow[i - 1] + lastRow[i];
    }
    result[lastRow.length] = 1;
    return result;
  }
}
