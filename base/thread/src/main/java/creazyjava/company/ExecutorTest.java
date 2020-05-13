package creazyjava.company;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by tgw61 on 2016/12/2.
 */
public class ExecutorTest {


  private final static Executor executor = Executors.newCachedThreadPool();

  //启用多线程
  public static void main(String[] args) {
    for (int i = 0; i <= 100; i++) {
      final int j = i;
//将 i 转化为  j，这样j 还是final类型的参与线程
      executor.execute(() -> {
        try {
          System.out.println(Thread.currentThread().getName() + "---" + j);
        } catch (Exception e) {
        }
      });
    }
  }
}
