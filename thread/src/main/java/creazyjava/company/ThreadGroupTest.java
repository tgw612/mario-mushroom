package creazyjava.company;

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
class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(getName() + " getName" + i);
        }
    }
}

public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("getName"
                + mainGroup.getName());
        System.out.println("isDaemon"
                + mainGroup.isDaemon());
        new MyThread("MyThread").start();
        ThreadGroup tg = new ThreadGroup("tg");
        tg.setDaemon(true);
        System.out.println("isDaemon"
                + tg.isDaemon());
        MyThread tt = new MyThread(tg, "tg");
        tt.start();
        new MyThread(tg, "tg").start();
    }
}

