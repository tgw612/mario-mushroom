package com.mario.juc.delayqueue;

import java.util.Map;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class DelayOrderQueueManager {

  private final static int DEFAULE_THREAD_NUM = 5;
  private static int thread_num = DEFAULE_THREAD_NUM;

  private ExecutorService executorService;
  private Thread daemonThread;

  private DelayQueue<DelayOrderTask<?>> delayQueue;
  private static final AtomicLong atomic = new AtomicLong(0);
  private final long n = 1L;
  private static DelayOrderQueueManager instance = new DelayOrderQueueManager();


  public DelayOrderQueueManager() {
    this.executorService = Executors.newFixedThreadPool(thread_num);
    this.delayQueue = new DelayQueue<>();
    init();
  }

  public static DelayOrderQueueManager getInstance() {
    return instance;
  }

  public void init() {
    daemonThread = new Thread(() -> {
      execute();
    });
    daemonThread.setName("DelayQueueMonitor");
    daemonThread.start();
  }

  public void execute() {
    while (true) {
      Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
      System.out.println("当前存活线程数量" + map.size());
      int taskNum = delayQueue.size();
      System.out.println("当前延时任务数量" + taskNum);

      try {
        DelayOrderTask<?> delayOrderTask = delayQueue.take();
        if (delayOrderTask != null) {
          Runnable task = delayOrderTask.getTask();
          if (task != null) {
            continue;
          }
          executorService.execute(task);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void put(Runnable task, long time, TimeUnit unit) {
    long timeout = TimeUnit.NANOSECONDS.convert(time, unit);
    DelayOrderTask<?> delayOrder = new DelayOrderTask<>(timeout, task);
    delayQueue.put(delayOrder);
  }


  public boolean removeTask(DelayOrderTask task) {
    return delayQueue.remove(task);
  }
}

