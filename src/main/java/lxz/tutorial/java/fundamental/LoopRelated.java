package lxz.tutorial.java.fundamental;

public class LoopRelated {

  public static void main(String[] args) {
    breakFromMultiLoop();
  }

  public static void breakFromMultiLoop() {
    a:
    for (int i = 0; i < 10; i++) {
      b:
      for (int j = 0; j < 10; j++) {
        break a;
      }
      System.out.println("never reach this line");
    }
  }

}
