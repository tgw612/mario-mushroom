package com.yizhitong.product.center.common.util;


import java.util.concurrent.TimeUnit;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RFuture;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

@Component
public class RedissonLockUtil {

  private RedissonClient redissonClient;

  public void setRedissonClient(RedissonClient redissonClient) {
    this.redissonClient = redissonClient;
  }

  /***
   * @Description //加锁
   */
  public RLock getLock(String lockKey) {
    RLock lock = redissonClient.getLock(lockKey);
    return lock;
  }

  /***
   * @Description //获取公平锁
   */
  public RLock getFairLock(String lockKey) {
    RLock fairLock = redissonClient.getFairLock(lockKey);
    return fairLock;
  }

  /***
   * @Description //获取读写锁
   */
  public RReadWriteLock getReadWriteLock(String lockKey) {
    RReadWriteLock rwlock = redissonClient.getReadWriteLock(lockKey);
    return rwlock;
  }

  /***
   * @Description //获取信号量
   */
  public RSemaphore getSemaphore(String lockKey) {
    RSemaphore semaphore = redissonClient.getSemaphore(lockKey);
    return semaphore;
  }

  /***
   * @Description //获取countDownLatch
   */
  public RCountDownLatch getCountDownLatch(String lockKey) {
    RCountDownLatch rCountDownLatch = redissonClient.getCountDownLatch(lockKey);
    return rCountDownLatch;
  }

  /***
   * @Description //异步加锁
   */
  public RFuture<Boolean> tryLockAsync(String lockKey, int waitTime, int leaseTime,
      TimeUnit timeUnit) throws InterruptedException {
    RLock lock = redissonClient.getLock(lockKey);
    Thread.sleep(1000);
    return lock.tryLockAsync(waitTime, leaseTime, timeUnit);
  }

  /***
   * @Description //释放锁
   */
  public void unLock(String lockKey) {
    RLock lock = redissonClient.getLock(lockKey);
    lock.unlock();
  }

  /***
   * @Description //释放锁
   */
  public void unLock(RLock lock) {
    lock.unlock();
  }

  /***
   * @Description //带超时的锁   单位 秒
   */
  public RLock lock(String lockKey, int timeout) {
    RLock lock = redissonClient.getLock(lockKey);
    lock.lock(timeout, TimeUnit.SECONDS);
    return lock;
  }

  public RLock lock(String lockKey, TimeUnit timeUnit, int timeout) {
    RLock lock = redissonClient.getLock(lockKey);
    lock.lock(timeout, timeUnit);
    return lock;
  }

  /***
   * @param lockKey
   * @param waitTime 最多等待时间
   * @param leaseTime 上锁后自动释放锁时间
   */
  public boolean tryLock(String lockKey, int waitTime, int leaseTime) {
    RLock lock = redissonClient.getLock(lockKey);
    try {
      return lock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      return false;
    }
  }

  /***
   * @param lockKey
   * @param waitTime 最多等待时间
   * @param leaseTime 上锁后自动释放锁时间
   */
  public boolean tryLock(String lockKey, TimeUnit timeUnit, int waitTime, int leaseTime) {
    RLock lock = redissonClient.getLock(lockKey);
    try {
      return lock.tryLock(waitTime, leaseTime, timeUnit);
    } catch (InterruptedException e) {
      return false;
    }
  }

  /**
   * @param waitTime  最多等待时间
   * @param leaseTime 上锁后自动释放锁时间
   */
  public boolean tryLock(RLock lock, TimeUnit timeUnit, int waitTime, int leaseTime) {
    try {
      return lock.tryLock(waitTime, leaseTime, timeUnit);
    } catch (InterruptedException e) {
      return false;
    }
  }


  public boolean tryLock(RLock lock, TimeUnit timeUnit, int waitTime) {
    try {
      return lock.tryLock(waitTime, timeUnit);
    } catch (InterruptedException e) {
      return false;
    }
  }

  /**
   * @param waitTime  最多等待时间
   * @param leaseTime 上锁后自动释放锁时间
   */
  public boolean tryLock(RLock lock, int waitTime, int leaseTime) {
    try {
      return lock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      return false;
    }
  }

  /**
   * 请合理设置参数，以免影响系统性能
   *
   * @param lock
   * @param timeUnit
   * @param waitTime
   * @param leaseTime
   * @param tryCount
   * @return
   */
/*    public boolean whileTryLock(RLock lock, TimeUnit timeUnit, int waitTime, int leaseTime, int tryCount) {
        int maxTryCount = tryCount;
        while (!tryLock(lock, timeUnit, waitTime, leaseTime)) {
            --maxTryCount;
            if (maxTryCount <= 0) {
                return false;
            }
        }
        return true;
    }*/

}