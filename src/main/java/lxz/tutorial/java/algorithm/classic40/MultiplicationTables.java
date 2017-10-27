package lxz.tutorial.java.algorithm.classic40;

public class MultiplicationTables {

  public static void main(String[] args) {
    tab1();
    System.out.println();
    tab2();
    System.out.println();
    tab3();
  }

  private static void tab3() {
    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.printf(i + "*" + j + "=%-3d", i * j);
      }
      System.out.println();
    }
  }

  private static void tab2() {
    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j < i; j++) {
        System.out.printf("%7s", "");
      }
      for (int j = i; j <= 9; j++) {
        System.out.printf(i + "*" + j + "=%-3d", i * j);
      }
      System.out.println();
    }
  }

  private static void tab1() {
    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        System.out.printf(i + "*" + j + "=%-3d", i * j);
      }
      System.out.println();
    }
  }
}
