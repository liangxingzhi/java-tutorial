package lxz.tutorial.java.algorithm.classic40;

/**
 * 【程序10】 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在   第10次落地时，共经过多少米？第10次反弹多高？
 */
public class BallDrop {

  public static void main(String[] args) {
    int n = 4;
    double height = 100;
    double sum = 100;
    for (int i = 1; i <= n - 1; i++) {
      sum = sum + height;
      height = height / 2.0;
    }
    System.out.println("sum => " + sum + ", height => " + height);
  }
}

/**
 * not right
 */
class Ex10 {

  public static void main(String[] args) {
    double s = 0;
    double t = 100;
    for (int i = 1; i <= 2; i++) {
      s += t;
      t = t / 2;
    }
    System.out.println(s);
    System.out.println(t);

  }
}