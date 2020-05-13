package com.mario.sync;

/**
 * wait/notifyAll方式跟ReentrantLock/Condition方式的原理是一样的。
 * <p>
 * Java中每个对象都拥有一个内置锁，在内置锁中调用wait，notify方法相当于调用锁的Condition条件对象的await和signalAll方法。
 */
public class WaitNotifyAllTest {

  public synchronized void doWait() {
    System.out.println(Thread.currentThread().getName() + " run");
    System.out.println(Thread.currentThread().getName() + " wait for condition");
    try {
      this.wait();
      System.out.println(Thread.currentThread().getName() + " continue");
    } catch (InterruptedException e) {
      System.err.println(Thread.currentThread().getName() + " interrupted");
      Thread.currentThread().interrupt();
    }
  }

  /**
   * 这里需要注意的是由于Condition是由锁创建的， 所以调用wait/notifyAll方法的时候需要获得当前线程的锁，否则会发生IllegalMonitorStateException异常。
   */
  public synchronized void doNotify() {
    try {
      System.out.println(Thread.currentThread().getName() + " run");
      System.out.println(Thread.currentThread().getName() + " sleep 5 secs");
      Thread.sleep(5000l);
      this.notifyAll();
    } catch (InterruptedException e) {
      System.err.println(Thread.currentThread().getName() + " interrupted");
      Thread.currentThread().interrupt();
    }
  }

  public static void main(String[] args) {
    WaitNotifyAllTest waitNotifyAllTest = new WaitNotifyAllTest();
    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        waitNotifyAllTest.doWait();
      }
    });
    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        waitNotifyAllTest.doNotify();
      }
    });
    thread1.start();
    thread2.start();
  }
}
