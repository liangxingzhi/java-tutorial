package lxz.tutorial.java.algorithm.classic40;

import java.util.ArrayList;

/**
 * 【程序18】   题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。
 *
 * 已抽签决定比赛名单。有人向队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
 */
public class PingPong {

  public static void main(String[] args) {
    char[] ary1 = {'a', 'b', 'c'};
    char[] ary2 = {'x', 'y', 'z'};
    for (int i = 0; i < ary2.length; i++) {
      for (int j = 0; j < ary2.length; j++) {
        for (int k = 0; k < ary2.length; k++) {
          if (ary2[i] != ary2[j] && ary2[j] != ary2[k] && ary2[i] != ary2[k]) {
            System.out.println("option: " + ary2[i] + "" + ary2[j] + "" + ary2[k]);
            if (ary2[i] != 'x' && ary2[k] != 'x' && ary2[k] != 'z') {
              System.out.println("selected option: " + ary2[i] + "" + ary2[j] + "" + ary2[k]);
            }
          }
        }
      }
    }

    System.out.println(ary1);
    System.out.println(ary2);

  }
}


/**
 * wrong demo
 */
class pingpang {

  String a, b, c;

  public pingpang(String a, String b, String c) {
    super();
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public static void main(String[] args) {
    String[] op = {"x", "y", "z"};
    ArrayList<pingpang> arrayList = new ArrayList<pingpang>();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          pingpang a = new pingpang(op[i], op[j], op[k]);
          if (!a.a.equals(a.b) && !a.b.equals(a.c) && !a.a.equals("x")
              && !a.c.equals("x") && !a.c.equals("z")) {
            arrayList.add(a);
          }
        }
      }
    }
    for (Object a : arrayList) {
      System.out.println(a);
    }
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "a的对手是" + a + "," + "b的对手是" + b + "," + "c的对手是" + c + "\n";
  }
}