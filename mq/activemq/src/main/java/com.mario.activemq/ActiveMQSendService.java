package com.mario.activemq;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class ActiveMQSendService {

  private static final Logger logger = LoggerFactory.getLogger(ActiveMQSendService.class);

  private JmsMessagingTemplate jmsMessagingTemplate;

  private Queue queueQueue;

  private ActiveMQTopic activeMQTopic;

  private ActiveMQTopic virtualTopicQueue;

//    @Autowired
//    public ActiveMQSendService(JmsMessagingTemplate jmsMessagingTemplate,
//                              Queue queueQueue,

//                              ActiveMQTopic topicQueue) {
//
//        this.jmsMessagingTemplate = jmsMessagingTemplate;
//        this.queueQueue = queueQueue;
//        this.activeMQTopic = topicQueue;
//    }

  @Autowired

  public ActiveMQSendService(JmsMessagingTemplate jmsMessagingTemplate,

      Queue queueQueue,

      ActiveMQTopic topicQueue,

      ActiveMQTopic virtualTopicQueue) {

    this.jmsMessagingTemplate = jmsMessagingTemplate;

    this.queueQueue = queueQueue;

    this.activeMQTopic = topicQueue;

    this.virtualTopicQueue = virtualTopicQueue;

  }

  public void sendQueueMessage(String message) {

    logger.info("send queue:{}", message);

    jmsMessagingTemplate.convertAndSend(queueQueue, message);

  }

  public void sendTopicMessage(String message) {

    logger.info("send topic:{}", message);

    jmsMessagingTemplate.convertAndSend(activeMQTopic, message);

  }

  public void sendVirtualTopicQueue(String message) {

    logger.info("send virtualTopic:{}", message);

    jmsMessagingTemplate.convertAndSend(virtualTopicQueue, message);

  }
}
