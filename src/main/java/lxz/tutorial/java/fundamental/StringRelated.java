package lxz.tutorial.java.fundamental;

import java.lang.reflect.Field;
import org.springframework.util.Assert;

public class StringRelated {

  public static String valueField() throws Exception {
    Field f = String.class.getDeclaredField("value");
    f.setAccessible(true);
    char[] c1 = (char[]) f.get(new String());
    char[] c2 = (char[]) f.get(new String());
    Assert.isTrue(c1 == c2, "两个新创建的字符串内部的 char[] value 必须相同");
    return null;
  }

  public static String string() throws Exception {
    System.out.println("" == "");
    System.out.println(new String() == new String());
    return "";
  }

  public static void main(String[] args) throws Exception {
    string();
    valueField();
    compare();
    compare2();

    System.out.println(reverse("haha"));
    System.out.println(reverse(null));
    System.out.println(new StringBuilder("huhu").reverse());
  }

  public static void compare() {

    String good = new StringBuilder("go").append("od").toString();
    Assert.isTrue(good.intern() == good, "same reference");

    String java = new StringBuilder("ja").append("va").toString();
    Assert.isTrue(java.intern() != java, "not same reference, java string is already in pool");

    String main = new StringBuilder("ma").append("in").toString();
    Assert.isTrue(main.intern() != main, "not same reference, main string is already in pool");

    String clazz = new StringBuilder("cla").append("ss").toString();
    Assert.isTrue(clazz.intern() == clazz, "not same reference, class string is not in pool");

    Assert.isTrue(new String("xxx") != new String("xxx"), "not same reference, can't be equal");
    Assert.isTrue(new String("xxx").intern() == new String("xxx").intern(),
        "equal, because return same from const pool");
    Assert.isTrue(new String("xxx").intern() != new String("xxx"), "can't be same reference");


  }

  public static void compare2() {
    System.out.println("-------------------- compare2 ------------------");
    String s1 = "Programming";
    String s2 = new String("Programming");
    String s3 = "Program";
    String s4 = "ming";
    String s5 = "Program" + "ming";
    String s6 = s3 + s4;
    System.out.println(s1 == s2);
    System.out.println(s1 == s5);
    System.out.println(s1 == s6);
    System.out.println(s1 == s6.intern());
    System.out.println(s2 == s2.intern());
  }

  public static String reverse(String input) {
    if (input == null || input.length() <= 1) {
      System.out.println("finally");
      return input;
    }
    return reverse(input.substring(1)) + input.charAt(0);
  }
}
