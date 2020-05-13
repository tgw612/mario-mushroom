import com.mario.rabbitmq.HelloApplication;
import com.mario.rabbitmq.Sender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class HelloApplicationTest {

  @Autowired
  private Sender sender;

  @Test
  public void hello() throws Exception {
    sender.send();
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }
}