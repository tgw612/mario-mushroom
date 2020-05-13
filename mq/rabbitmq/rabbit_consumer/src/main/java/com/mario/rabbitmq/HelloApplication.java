package com.mario.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class HelloApplication {

  public static void main(String[] args) {
    SpringApplication.run(HelloApplication.class, args);
  }

}