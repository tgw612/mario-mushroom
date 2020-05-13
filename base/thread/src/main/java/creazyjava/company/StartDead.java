package creazyjava.company;

/**
 * Description: <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> <br/>Copyright (C),
 * 2001-2016, Yeeku.H.Lee <br/>This program is protected by copyright laws. <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class StartDead extends Thread {

  private int i;

  public void run() {
    for (; i < 100; i++) {
      System.out.println(getName() + " " + i);
    }
  }

  public static void main(String[] args) {
    StartDead sd = new StartDead();
    for (int i = 0; i < 300; i++) {
      System.out.println(Thread.currentThread().getName()
          + " " + i);
      if (i == 20) {
        sd.start();
        System.out.println(sd.isAlive());
      }
      if (i > 20 && !sd.isAlive()) {
        sd.start();
      }
    }
  }
}

