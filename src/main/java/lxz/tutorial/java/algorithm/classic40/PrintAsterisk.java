package lxz.tutorial.java.algorithm.classic40;


// print following asterisks
//    *
//    ***
//    *****
//    *******
//    *****
//    ***
//    *
public class PrintAsterisk {

  public static void main(String[] args) {
    int n = 3;
    print1(n);
    print2(n);
  }

  public static void print1(int n) {
    for (int i = 0; i < n + 1; i++) {
      for (int j = 1; j <= 2 * i + 1; j++) {
        System.out.print('*');
      }
      System.out.println();
    }
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 1; j <= 2 * i + 1; j++) {
        System.out.print('*');
      }
      System.out.println();
    }
  }

  public static void print2(int n) {
    for (int i = 0; i < n + 1; i++) {
      if (i < n) {
        System.out.printf("%" + (n - i) + "s", " ");
      }
      for (int j = 1; j <= 2 * i + 1; j++) {
        System.out.print('*');
      }
      System.out.println();
    }
    for (int i = n - 1; i >= 0; i--) {
      System.out.printf("%" + (n - i) + "s", " ");
      for (int j = 1; j <= 2 * i + 1; j++) {
        System.out.print('*');
      }
      System.out.println();
    }
  }
}

class StartG {

  public static void main(String[] args) {
    int i = 0;
    int j = 0;
    for (i = 1; i <= 4; i++) {
      for (j = 1; j <= 2 * i - 1; j++) {
        System.out.print("*");
      }
      System.out.println("");
    }
    for (i = 4; i >= 1; i--) {
      for (j = 1; j <= 2 * i - 3; j++) {
        System.out.print("*");
      }
      System.out.println("");
    }
  }
}