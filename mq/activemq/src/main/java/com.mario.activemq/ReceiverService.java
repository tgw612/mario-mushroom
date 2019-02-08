package com.mario.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class ReceiverService {


    private static final Logger logger = LoggerFactory.getLogger(ReceiverService.class);

    @JmsListener(destination = "queue", containerFactory = "queueListenerFactory")
    public void receiveTestQueue(String receiveStr) throws JMSException {
        logger.info("=======================queue:{}", receiveStr);

    }


    @JmsListener(destination = "orders", containerFactory = "topicListenerFactory")
    public void receiveTopicQueue(String receiveStr) throws JMSException {
        logger.info("=======================orders:{}", receiveStr);

    }

    @JmsListener(destination = "Consumer.B.VirtualTopic.Orders", containerFactory = "queueListenerFactory")
    public void receiveTopicVirtualQueue(String receiveStr) throws JMSException {
        logger.info("=======================Consumer.B.VirtualTopic.topic:{}", receiveStr);

    }

}
