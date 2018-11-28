package com.mario.juc.delayqueue;

import java.util.concurrent.DelayQueue;

public class Consumer implements Runnable {
    private DelayQueue<Message> queue;

    public Consumer(DelayQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message take = queue.take();
                System.out.println("消费消息id:" + take.getId() + "消息体:" + take.getBody());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
