package pers.ylin.demo.queue;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Ylin on 2018/9/21
 */
@Component
@RabbitListener(queues = "hello")
public class helloConsumer {

    @RabbitHandler
    public void process(String message) {
        System.out.println("接收:" + message);
    }
}
