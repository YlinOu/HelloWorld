package pers.ylin.demo.rabbit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Ylin on 2018/9/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() throws InterruptedException {
        while (true) {
            rabbitTemplate.convertAndSend("hello", "Hello World!!!");
            Thread.sleep(500);
        }
    }


}