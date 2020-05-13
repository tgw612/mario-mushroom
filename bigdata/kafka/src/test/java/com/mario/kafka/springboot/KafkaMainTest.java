package com.mario.kafka.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest(classes = KafkaMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class KafkaMainTest {

  @Resource
  private IMessageProducerService messageService;

  @Test
  public void testStart() throws Exception {
    for (int x = 0; x < 100; x++) {
      this.messageService.sendMessage("study - " + x);
    }
  }

}
