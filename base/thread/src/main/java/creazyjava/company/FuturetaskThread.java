package creazyjava.company;

import java.util.concurrent.FutureTask;

/**
 * Description: <br/>��վ: <a href="http://www.crazyit.org">���Java����</a> <br/>Copyright (C),
 * 2001-2016, Yeeku.H.Lee <br/>This program is protected by copyright laws. <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */

public class FuturetaskThread {

  public static void main(String[] args) {
    FuturetaskThread rt = new FuturetaskThread();
    FutureTask<Integer> task = new FutureTask<>(() -> {
      int i = 0;
      for (; i < 100; i++) {
        System.out.println(Thread.currentThread().getName()
            + "count:" + i);
      }
      return i;
    });
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName()
          + " currentThread:" + i);
      if (i == 20) {
        new Thread(task, "FutureTask").start();
      }
    }
    try {
      System.out.println("result" + task.get());
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

