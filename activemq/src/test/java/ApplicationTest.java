import com.mario.activemq.ActiveMQSendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationTest {


    @Resource
    private ActiveMQSendService activeMQSendService;

    @Test
    public void testSendQueue() {
        activeMQSendService.sendQueueMessage("queue===============");
    }

    @Test
    public void testSendTopic() {
        activeMQSendService.sendTopicMessage("topic================");
    }


    @Test
    public void testSendVirtualTopic() {
        activeMQSendService.sendVirtualTopicQueue("virtualTopic==============");
    }


}
