package pers.ylin.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ylin on 2018/9/21
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }
}
