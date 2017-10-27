package lxz.tutorial.java.algorithm.classic40;

public class SubDigit {

  public static void main(String[] args) {
    int number = 12345678;
    number = number / 1000;
    String str = String.valueOf(number);

    for (int i = str.length() - 1; i >= 0; i--) {
      System.out.println(str.charAt(i));
      if (str.length() - 1 - i == 3) {
        break;
      }
    }
  }

}
