package net.rabbitmq.springboot.consumer;

import lombok.extern.slf4j.Slf4j;
import net.rabbitmq.springboot.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(User user) {
        log.info("Json 메시지 받음: {}", user);
    }
}
