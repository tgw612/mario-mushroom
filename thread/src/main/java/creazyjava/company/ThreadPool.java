package creazyjava.company;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tgw61 on 2016/12/2.
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            Runnable target = () -> {
                System.out.println(Thread.currentThread().getName() + "finalI:" + finalI);
            };
            pool.submit(target);
            pool.shutdown();
        }
    }

}
