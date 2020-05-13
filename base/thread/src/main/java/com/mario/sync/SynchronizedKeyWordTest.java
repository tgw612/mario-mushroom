package com.mario.sync;

/**
 * 输出结果跟ReentrantLock一样，这个例子说明内置锁可以作用在方法上。它还可以作用到变量，静态方法上。
 * <p>
 * synchronized跟ReentrantLock相比，有几点局限性：
 * <p>
 * 加锁的时候不能设置超时。ReentrantLock有提供tryLock方法，可以设置超时时间， 如果超过了这个时间并且没有获取到锁，就会放弃，而synchronized却没有这种功能
 * ReentrantLock可以使用多个Condition，而synchronized却只能有1个 不能中断一个试图获得锁的线程 ReentrantLock可以选择公平锁和非公平锁
 * ReentrantLock可以获得正在等待线程的个数，计数器等
 */
public class SynchronizedKeyWordTest {

  public synchronized void execute() {
    System.out.println(Thread.currentThread().getName() + " do something synchronize");
    try {
      anotherLock();
      Thread.sleep(5000l);
    } catch (InterruptedException e) {
      System.err.println(Thread.currentThread().getName() + " interrupted");
      Thread.currentThread().interrupt();
    }
  }

  public synchronized void anotherLock() {
    System.out.println(Thread.currentThread().getName() + " invoke anotherLock");
  }

  public static void main(String[] args) {
    SynchronizedKeyWordTest reentrantLockTest = new SynchronizedKeyWordTest();
    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        reentrantLockTest.execute();
      }
    });
    Thread thread2 = new Thread(new Runnable() {
      @Override
      public void run() {
        reentrantLockTest.execute();
      }
    });
    thread1.start();
    thread2.start();
  }
}
