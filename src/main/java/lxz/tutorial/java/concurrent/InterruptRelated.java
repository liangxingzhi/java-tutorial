package lxz.tutorial.java.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptRelated {

  public static void main(String[] args) {
    testThread4();
  }

  public static void testThread1() {
    InterruptedThread1 thread1 = new InterruptedThread1();
    thread1.start();
    thread1.interrupt();
    System.out.println("after call interrupt of thread1");
  }

  public static void testThread2() {
    InterruptedThread2 thread2 = new InterruptedThread2();
    thread2.setName("thread2");
    thread2.start();
    thread2.interrupt();
    System.out.println("after call interrupt of thread2");
  }

  public static void testThread3() {
    InterruptedThread3 thread3_1 = new InterruptedThread3();
    thread3_1.setName("thread3_1");
    thread3_1.start();
    try {
      Thread.currentThread().sleep(100);
    } catch (InterruptedException e) {

    }

    InterruptedThread3 thread3_2 = new InterruptedThread3();
    thread3_2.setName("thread3_2");
    thread3_2.start();
    thread3_2.interrupt();
  }

  public static void testThread4() {
    InterruptedThread4 thread4_1 = new InterruptedThread4();
    InterruptedThread4 thread4_2 = new InterruptedThread4();
    thread4_1.start();
    thread4_2.start();
    thread4_2.interrupt();
  }

  public static void testThread5() {
    InterruptedThread5 thread5_1 = new InterruptedThread5();
    InterruptedThread5 thread5_2 = new InterruptedThread5();
    thread5_1.start();
    thread5_2.start();
    try {
      Thread.currentThread().sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    thread5_2.interrupt();
  }


  /**
   * can't interrupt a running state thread, but thread know someone try to interrupt it by calling
   * isInterrupted()
   */
  static class InterruptedThread1 extends Thread {

    @Override
    public void run() {
      int i = 100;
      while (true) {
        System.out.println("run in InterruptedThread1");
        if (Thread.currentThread().isInterrupted()) {
          System.out.println(Thread.currentThread().getName() + " is interrupted");
          if (i-- <= 0) {
            break;
          }
        }
      }
    }
  }

  /**
   * sleep/join/wait can be interrupted by throw new InterruptedException
   */
  static class InterruptedThread2 extends Thread {

    @Override
    public void run() {
      while (true) {
        System.out.println("run in InterruptedThread2");
        try {
          Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
          if (Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + " is interrupted");
          }
          break;
        }

      }
    }
  }

  static class InterruptedThread3 extends Thread {

    private static final Object lock = new Object();

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + " is ready to run");
      synchronized (lock) {
        while (true) {
          try {
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.currentThread().sleep(1000);
          } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " is interrupted");
          }
        }
      }
    }
  }

  /**
   * lock can't respond to interrupt
   */
  static class InterruptedThread4 extends Thread {

    private static final Lock lock = new ReentrantLock();

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + " is ready to run");
      lock.lock();
      try {
        // sleep will always respond to interrupt
        // Thread.currentThread().sleep(1000);
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 1) {
          System.out.println(Thread.currentThread().getName() + " is running");
          System.out.println(
              Thread.currentThread().getName() + " interrupted ? " + Thread.currentThread()
                  .isInterrupted());
        }

      } catch (Exception e) {
        System.out.println(Thread.currentThread().getName() + " is interrupted");
      } finally {
        lock.unlock();
      }
    }
  }

  /**
   * lockInterruptibly can respond to interrupt
   */
  static class InterruptedThread5 extends Thread {

    private static final Lock lock = new ReentrantLock();

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + " is ready to run");
      try {
        lock.lockInterruptibly();
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 1) {
          System.out.println(Thread.currentThread().getName() + " is running");
        }

      } catch (InterruptedException e) {
        System.out.println(Thread.currentThread().getName() + " is interrupted");
      } finally {
        lock.unlock();
      }
    }
  }


}
