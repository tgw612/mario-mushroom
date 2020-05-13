package creazyjava.company;

/**
 * Description: <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> <br/>Copyright (C),
 * 2001-2016, Yeeku.H.Lee <br/>This program is protected by copyright laws. <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class PriorityTest extends Thread {

  public PriorityTest(String name) {
    super(name);
  }

  public void run() {
    for (int i = 0; i < 50; i++) {
      System.out.println(getName() + ",getName:"
          + getPriority() + "getPriority:" + i);
    }
  }

  public static void main(String[] args) {
    Thread.currentThread().setPriority(6);
    for (int i = 0; i < 30; i++) {
      if (i == 10) {
        PriorityTest low = new PriorityTest("low");
        low.start();
        System.out.println("low:"
            + low.getPriority());
        low.setPriority(Thread.MIN_PRIORITY);
      }
      if (i == 20) {
        PriorityTest high = new PriorityTest("high");
        high.start();
        System.out.println("high:"
            + high.getPriority());
        high.setPriority(Thread.MAX_PRIORITY);
      }
    }
  }
}
