package com.mario.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadConfig {

  @Value("$(spring.task.pool.corePoolSize:10)")
  private Integer corePoolSize;
  @Value("$(spring.task.pool.maxPoolSize:20)")
  private Integer maxPoolSize;
  @Value("$(spring.task.pool.keepAliveTime:60*5)")
  private Integer keepAliveTime;
  @Value("$(spring.task.pool.queueCapacity:100)")
  private Integer queueCapacity;

  public ThreadConfig() {
  }

  @Bean(value = "executor1", destroyMethod = "destroy")
  public ThreadPoolTaskExecutor executor1() {
    ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
    poolTaskExecutor.setCorePoolSize(corePoolSize);
    poolTaskExecutor.setMaxPoolSize(maxPoolSize);
    poolTaskExecutor.setKeepAliveSeconds(keepAliveTime);
    poolTaskExecutor.setQueueCapacity(queueCapacity);
    poolTaskExecutor.setThreadNamePrefix("executor1");
    poolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
    poolTaskExecutor.setAwaitTerminationSeconds(60);
    poolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    poolTaskExecutor.initialize();
    return poolTaskExecutor;
  }
}
