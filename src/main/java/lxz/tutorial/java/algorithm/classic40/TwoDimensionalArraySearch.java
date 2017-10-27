package lxz.tutorial.java.algorithm.classic40;

public class TwoDimensionalArraySearch {

  public static void main(String[] args) {
    int[][] dArray = {{1, 2, 3}, {4, 6}, {7, 8, 9}, {10, 11, 38}};
    int search = 6;
    search(dArray, search);
  }

  public static void search(int[][] dArray, int search) {
    for (int i = 0; i < dArray.length; i++) {
      for (int j = dArray[i].length - 1; j >= 0; j--) {
        if (search > dArray[i][j]) {
          //next row continue search
          break;
        } else if (search == dArray[i][j]) {
          System.out.println(search + " position is (" + i + ", " + j + ")");
          return;
        } else {
          continue;
        }
      }
    }
    System.out.println("no such element in this array");
    return;
  }
}
