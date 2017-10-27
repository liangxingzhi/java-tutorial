package lxz.tutorial.java.concurrent;

import java.util.ArrayList;
import java.util.List;
// 如果没有做synchronized处理
//Exception in thread "Thread-0" java.util.ConcurrentModificationException
//    at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
//    at java.util.ArrayList$Itr.next(ArrayList.java:851)
//    at java.util.AbstractCollection.toString(AbstractCollection.java:461)
//    at java.lang.String.valueOf(String.java:2994)
//    at java.io.PrintStream.println(PrintStream.java:821)
//    at lxz.tutorial.java.concurrent.WaitRelated$ProducerThread.run(WaitRelated.java:22)
//    Exception in thread "Thread-1" java.lang.ArrayIndexOutOfBoundsException: -1
//    at java.util.ArrayList.elementData(ArrayList.java:418)
//    at java.util.ArrayList.remove(ArrayList.java:495)
//    at lxz.tutorial.java.concurrent.WaitRelated$ConsumerThread.run(WaitRelated.java:36)

public class WaitRelated {

  static final List<Long> list = new ArrayList<>();
  static volatile boolean flag = false;

  public static void main(String[] args) {

    Thread p = new ProducerThread();
    p.start();
    Thread c = new ConsumerThread();
    c.start();
    long start = System.currentTimeMillis();
    while (System.currentTimeMillis() - start < 10000) {
      Thread.currentThread().yield();
    }

    flag = true;

    p.interrupt();
    c.interrupt();

  }

  static class ProducerThread extends Thread {

    @Override
    public void run() {

// wait 必须在synchronized块中，不然会报下边的异常
//      Exception in thread "Thread-0" java.lang.IllegalMonitorStateException
//      at java.lang.Object.wait(Native Method)
//      at java.lang.Object.wait(Object.java:502)
//      at lxz.tutorial.java.concurrent.WaitRelated$ProducerThread.run(WaitRelated.java:33)

      while (!flag) {
        synchronized (list) {
          while (list.size() == 10) {
            try {
              list.wait();
            } catch (InterruptedException e) {
              list.notifyAll();
              return;
            }
          }
          list.add(System.nanoTime());
          list.notifyAll();
        }
      }
    }
  }

  static class ConsumerThread extends Thread {

    @Override
    public void run() {
      while (!flag) {
        synchronized (list) {
          while (list.size() == 0) {
            try {
              list.wait();
            } catch (InterruptedException e) {
              list.notifyAll();
              return;
            }
          }
          list.remove(list.size() - 1);
          list.notifyAll();
        }
      }
    }
  }
}
