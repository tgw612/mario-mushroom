package creazyjava.sync.forkJoin;

import java.util.concurrent.*;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class ThreadPoolTest {
    public static void main(String[] args)
            throws Exception {
        // �����㹻���߳���֧��4��CPU���е��̳߳�
        // ����һ�����й̶��߳�����6�����̳߳�
        ExecutorService pool = Executors.newFixedThreadPool(6);
        // ʹ��Lambda���ʽ����Runnable����
        Runnable target = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()
                        + "��iֵΪ:" + i);
            }
        };
        // ���̳߳����ύ�����߳�
        pool.submit(target);
        pool.submit(target);
        // �ر��̳߳�
        pool.shutdown();
    }
}

