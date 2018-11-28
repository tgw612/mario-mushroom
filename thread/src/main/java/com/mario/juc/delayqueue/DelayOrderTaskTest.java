package com.mario.juc.delayqueue;

import java.util.concurrent.TimeUnit;

public class DelayOrderTaskTest {
    public static void main(String[] args) {

        DelayOrderWorker w1 = new DelayOrderWorker();
        DelayOrderWorker w2 = new DelayOrderWorker();
        DelayOrderWorker w3 = new DelayOrderWorker();

        DelayOrderQueueManager manager =DelayOrderQueueManager.getInstance();
        manager.put(w1,3,TimeUnit.SECONDS);
        manager.put(w2,6,TimeUnit.SECONDS);
        manager.put(w3,9,TimeUnit.SECONDS);
    }
}
