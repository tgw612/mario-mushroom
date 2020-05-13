package com.mario.kafka.springboot;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MessageProducerServiceImpl implements IMessageProducerService {

  @Resource
  private KafkaTemplate<String, String> kafkaTemplate;


  @Override
  public void sendMessage(String msg) {
    this.kafkaTemplate.sendDefault("study-key", msg);
  }
}