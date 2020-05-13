package com.mario.sync;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 这个例子表示同一时间段只能有1个线程执行execute方法。
 * <p>
 * 可重入锁中可重入表示的意义在于对于同一个线程，可以继续调用加锁的方法， 而不会被挂起。可重入锁内部维护一个计数器，对于同一个线程调用lock方法，计数器+1，调用unlock方法，计数器-1。
 */
public class ReentrantLockTest {

  private ReentrantLock lock = new ReentrantLock();

//    public void execute() {
//        lock.lock();
//        try {
//            System.out.println(Thread.currentThread().getName() + " do something synchronize");
//            try {
//                Thread.sleep(5000l);
//            } catch (InterruptedException e) {
//                System.err.println(Thread.currentThread().getName() + " interrupted");
//                Thread.currentThread().interrupt();
//            }
//        } finally {
//            lock.unlock();
//        }
//    }

  /**
   * 举个例子再次说明一下可重入的意思，在一个加锁方法execute中调用另外一个加锁方法anotherLock并不会被挂起， 可以直接调用(调用execute方法时计数器+1，然后内部又调用了anotherLock方法，计数器+1，变成了2)：
   */
  public void execute() {
    lock.lock();
    try {
      System.out.println(Thread.currentThread().getName() + " do something synchronize");
      try {
        anotherLock();
        Thread.sleep(5000l);
      } catch (InterruptedException e) {
        System.err.println(Thread.currentThread().getName() + " interrupted");
        Thread.currentThread().interrupt();
      }
    } finally {
      lock.unlock();
    }
  }

  public void anotherLock() {
    lock.lock();
    try {
      System.out.println(Thread.currentThread().getName() + " invoke anotherLock");
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
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
