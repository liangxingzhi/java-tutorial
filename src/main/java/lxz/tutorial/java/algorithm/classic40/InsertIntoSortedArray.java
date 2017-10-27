package lxz.tutorial.java.algorithm.classic40;

public class InsertIntoSortedArray {

  public static void main(String[] args) {
    int[] ary = {1, 2, 3, 4, 5, 7, 9, 13, 18};
    PrintUtil.print(insert(ary, 19));
    PrintUtil.print(insert(ary, 0));
    PrintUtil.print(insert(ary, 6));
    PrintUtil.print(insert(ary, 5));
  }

  public static int[] insert(int[] ary, int input) {
    int[] newArray = new int[ary.length + 1];
    int start = 0;
    int end = ary.length - 1;
    int mid = -1;
    while (start <= end) {
      mid = (start + end) / 2;
      if (ary[mid] > input) {
        end = mid - 1;
      } else if (ary[mid] < input) {
        start = mid + 1;
      } else {
        break;
      }
    }
    if (ary[mid] <= input) {
      mid = mid + 1;
    }
    for (int i = 0; i < newArray.length; i++) {
      if (i < mid) {
        newArray[i] = ary[i];
      } else if (i == mid) {
        newArray[i] = input;
      } else {
        newArray[i] = ary[i - 1];
      }
    }
    return newArray;
  }
}
