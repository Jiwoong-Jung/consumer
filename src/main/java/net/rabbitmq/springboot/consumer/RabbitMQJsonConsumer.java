package net.rabbitmq.springboot.consumer;

import lombok.extern.slf4j.Slf4j;
import net.rabbitmq.springboot.dto.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(String str) {
        log.info("Json 메시지 받음: {}", str);
        try {
//            String str = "{\"name\":\"John\",\"age\":\"30\"}";
            JSONObject jsonObject = new JSONObject(str);
            System.out.println("OBJECT : " + jsonObject.toString());
            log.info("name:{}", jsonObject.get("lastName"));
        } catch (JSONException err) {
            System.out.println("Exception : " + err.toString());
        }
    }
//    public void consumeJsonMessage(User user) {
//        log.info("Json 메시지 받음: {}", user.toString());
//    }
}
