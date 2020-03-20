package com.mario.sync;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * MySynchronizer并没有实现可重入功能，只是简单的一个独占锁。
 * AQS是很多同步工具类的基础，比如ReentrentLock里的公平锁和非公平锁，Semaphore里的公平锁和非公平锁，
 * CountDownLatch里的锁等他们的底层都是使用AbstractQueuedSynchronizer完成的。
 */
public class MySynchronizer extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {
        if(compareAndSetState(0, 1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        setState(0);
        setExclusiveOwnerThread(null);
        return true;
    }

    public void lock() {
        acquire(1);
    }

    public void unlock() {
        release(1);
    }

    public static void main(String[] args) {
        MySynchronizer mySynchronizer = new MySynchronizer();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mySynchronizer.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " run");
                    System.out.println(Thread.currentThread().getName() + " will sleep 5 secs");
                    try {
                        Thread.sleep(5000l);
                        System.out.println(Thread.currentThread().getName() + " continue");
                    } catch (InterruptedException e) {
                        System.err.println(Thread.currentThread().getName() + " interrupted");
                        Thread.currentThread().interrupt();
                    }
                } finally {
                    mySynchronizer.unlock();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mySynchronizer.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " run");
                } finally {
                    mySynchronizer.unlock();
                }
            }
        });
        thread1.start();
        thread2.start();
    }

}
