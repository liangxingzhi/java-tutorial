package lxz.tutorial.java.algorithm.classic40;

/**
 * 【程序25】   题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
 */
public class PalindromicNumber {

  public static void main(String[] args) {
    System.out.println(guessNumber(12321));
    System.out.println(guessNumber(123321));
    System.out.println(guessNumber(1234321));
    System.out.println(guessNumber(12345321));
    System.out.println(guessNumber(1));
    System.out.println(guessNumber(0));
  }

  public static boolean guessNumber(int i ) {
    System.out.printf("%-8d ", i);
    String s = String.valueOf(i);
    int start = 0;
    int end = s.length() -1;
    while(s.charAt(start) == s.charAt(end)) {
      start++;
      end--;
      if(start >= end) {
        return true;
      }
    }
    return false;
  }
}
