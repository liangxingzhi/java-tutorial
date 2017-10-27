package lxz.tutorial.java.concurrent;

public class UnlimitedNewThread {

  public static void main(String[] args) {
    while (true) {
      new Thread() {
        @Override
        public void run() {
          super.run();
          while (true) {
            try {
              Thread.sleep(1000);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }.start();
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    }
  }
