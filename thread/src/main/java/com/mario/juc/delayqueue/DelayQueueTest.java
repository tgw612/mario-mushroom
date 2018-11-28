package com.mario.juc.delayqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DelayQueueTest {
    public static void main(String[] args) {
        DelayQueue<Message> queue =new DelayQueue<>();
        Message m1=new Message(1,"world",3000);
        Message m2=new Message(2,"hello",13000);
        queue.offer(m1);
        queue.offer(m2);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new Consumer(queue));
        executorService.shutdown();
    }
}
