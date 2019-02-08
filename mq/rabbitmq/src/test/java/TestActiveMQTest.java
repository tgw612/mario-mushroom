import com.mario.rabbitmq.springboot.ActiveMQApp;
import com.mario.rabbitmq.springboot.IMessageProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest(classes = ActiveMQApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestActiveMQTest {
    @Test
    public void testStart() throws Exception {
        Thread.sleep(Long.MAX_VALUE);
    }

    @Resource
    private IMessageProducerService messageProducer;

    @Test
    public void testSend() throws Exception {
        for (int x = 0; x < 100; x++) {
            this.messageProducer.sendMessage("study - " + x);
        }
    }

}
