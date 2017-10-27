package lxz.tutorial.java.algorithm.classic40;

public class CharacterCount {

  public static void main(String[] args) {
    System.out.println("好".matches("[\u4E00-\u9FFFF]"));
    count("Hello World 123!我的天哪");
  }

  public static void count(String str) {
    if (str == null || str.isEmpty()) {
      System.out.println("str is null or empty");
      return;
    }
    int number = 0;
    int alpha = 0;
    int han = 0;
    int other = 0;
    int space = 0;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        number++;
      } else if ((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'a'
          && str.charAt(i) <= 'z')) {
        alpha++;
      } else if (str.charAt(i) == ' ') {
        space++;
      } else if (String.valueOf(str.charAt(i)).matches("\u4e00-\u9fa5")) {
        han++;
      } else {
        other++;
      }
    }
    System.out.println(
        "Counting result is number =>" + number + ", alpha => " + alpha + ", han => " + han
            + ", space => " + space
            + ", other => " + other);
  }

  public static void count2(char chr) {

  }
}
