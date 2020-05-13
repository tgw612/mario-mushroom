package creazyjava.company;

/**
 * Description: <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> <br/>Copyright (C),
 * 2001-2016, Yeeku.H.Lee <br/>This program is protected by copyright laws. <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class JoinThread extends Thread {

  public JoinThread(String name) {
    super(name);
  }

  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println(getName() + "  " + i);
    }
  }

  public static void main(String[] args) throws Exception {
    new JoinThread("JoinThread").start();
    for (int i = 0; i < 100; i++) {
      if (i == 20) {
        JoinThread jt = new JoinThread("JoinThread20");
        jt.start();
        jt.join();
      }
      System.out.println(Thread.currentThread().getName()
          + "  " + i);
    }
  }
}
