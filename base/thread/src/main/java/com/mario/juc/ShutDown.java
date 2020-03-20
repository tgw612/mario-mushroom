package com.mario.juc;


import java.util.concurrent.TimeUnit;

/**
 * Created by tgw61 on 2017/7/20.
 */
public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
        Runable one = new Runable();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        Runable two = new Runable();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }


    private static class Runable implements Runnable {
        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i=" + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
