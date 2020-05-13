package com.mario.juc.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayOrderTask<T extends Runnable> implements Delayed {

  private final long time;
  private final T task;

  public DelayOrderTask(long time, T task) {
    this.time = time;
    this.task = task;
  }

  @Override
  public long getDelay(TimeUnit unit) {
    return unit.convert(this.time - System.nanoTime(), TimeUnit.NANOSECONDS);
  }

  @Override
  public int compareTo(Delayed o) {
    DelayOrderTask other = (DelayOrderTask) o;
    long diff = time - other.time;
    if (diff > 0) {
      return 1;
    } else if (diff < 0) {
      return -1;
    } else {
      return 0;
    }

  }

  public T getTask() {
    return task;
  }

  public int hashCode() {
    return task.hashCode();
  }
}
