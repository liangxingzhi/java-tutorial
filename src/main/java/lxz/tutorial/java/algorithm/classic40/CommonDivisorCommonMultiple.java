package lxz.tutorial.java.algorithm.classic40;

public class CommonDivisorCommonMultiple {

  public static void main(String[] args) {
    System.out
        .println("greatest common divisor of 24 and 36 is : " + greatestCommonDivisor2(24, 36));
    System.out
        .println("greatest common divisor of 36 and 36 is : " + greatestCommonDivisor2(36, 36));
    System.out.println("least common multiple of 24 and 36 is : " + leastCommonMultiple(24, 36));
    System.out.println("least common divisor of 36 and 36 is : " + leastCommonMultiple(36, 36));
  }

  /**
   * @param x >= 0
   * @param y >= 0, x<=y
   *
   * great greater greatest
   */
  public static int greatestCommonDivisor(int x, int y) {
    if (x < 1 || y < 1 || x > y) {
      throw new IllegalArgumentException("x and y should be greater than 0, x <= y");
    }
    int result = 1;
    if (y % x == 0) {
      return x;
    }
    for (int i = 2; i <= x && i <= y / 2; i++) {
      if (x % i == 0 && y % i == 0) {
        result = i;
      }
    }
    return result;
  }

  /**
   * @param x >= 0
   * @param y >= 0, x<=y
   *
   * great greater greatest
   * @return greatest
   */
  public static int greatestCommonDivisor2(int x, int y) {
    if (x < 1 || y < 1 || x > y) {
      throw new IllegalArgumentException("x and y should be greater than 0, x <= y");
    }
    while (true) {
      if (x % y == 0) {
        return y;
      }
      int tmp = x % y;
      x = y;
      y = tmp;
    }
  }


  /**
   * @param x >= 0
   * @param y >= 0, x<=y
   * @return least common multiple
   *
   * little less least
   */
  public static int leastCommonMultiple(int x, int y) {
    int greatestCommonDivisor = greatestCommonDivisor(x, y);
    return x * y / greatestCommonDivisor;
  }
}
