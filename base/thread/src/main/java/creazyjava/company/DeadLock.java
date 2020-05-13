package creazyjava.company;

/**
 * Description: <br/>???: <a href="http://www.crazyit.org">???Java????</a> <br/>Copyright (C),
 * 2001-2016, Yeeku.H.Lee <br/>This program is protected by copyright laws. <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
class A {

  public synchronized void foo(B b) {
    System.out.println("B: " + Thread.currentThread().getName()
        + "foo()");
    try {
      Thread.sleep(200);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
    System.out.println("B: " + Thread.currentThread().getName()
        + " B--last()");
    b.last();
  }

  public synchronized void last() {
    System.out.println("last()");
  }
}

class B {

  public synchronized void bar(A a) {
    System.out.println("A: " + Thread.currentThread().getName()
        + "B--bar()");   // ??
    try {
      Thread.sleep(200);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
    System.out.println("currentThread: " + Thread.currentThread().getName()
        + " last()");  // ??
    a.last();
  }

  public synchronized void last() {
    System.out.println("B--last()");
  }
}

public class DeadLock implements Runnable {

  A a = new A();
  B b = new B();

  public void init() {
    Thread.currentThread().setName("currentThread init");
    a.foo(b);
    System.out.println("init done");
  }

  public void run() {
    Thread.currentThread().setName("currentThread run");
    b.bar(a);
    System.out.println("run done");
  }

  public static void main(String[] args) {
    DeadLock dl = new DeadLock();
    new Thread(dl).start();
    dl.init();
  }
}

