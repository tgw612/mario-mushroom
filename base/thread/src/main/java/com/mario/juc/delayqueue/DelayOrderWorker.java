package com.mario.juc.delayqueue;

public class DelayOrderWorker implements Runnable {

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + "do something..");
  }
}
