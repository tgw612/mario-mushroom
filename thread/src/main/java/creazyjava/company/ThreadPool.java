package creazyjava.company;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tgw61 on 2016/12/2.
 */
public class ThreadPool {
    @Test
    public void Executor() {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            Runnable target = () -> {
                System.out.println(Thread.currentThread().getName() + "��iֵΪ:" + finalI);
            };
            pool.submit(target);
            pool.shutdown();
        }
    }
}
