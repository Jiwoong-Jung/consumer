package net.rabbitmq.springboot.consumer;

import lombok.extern.slf4j.Slf4j;
import net.rabbitmq.springboot.componet.SendData;
import net.rabbitmq.springboot.dto.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Service
@Slf4j
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(String str) {
        log.info("Json 메시지 받음: {}", str);
        try {
            JSONObject jsonObject = new JSONObject(str);
            System.out.println("OBJECT : " + jsonObject.toString());
            log.info("name:{}", jsonObject.get("lastName"));
            applicationReadyEvent((Integer) jsonObject.get("id"));

        } catch (JSONException err) {
            System.out.println("Exception : " + err.toString());
        }
    }
//    public void consumeJsonMessage(final User user) {
//        log.info("Json 메시지 받음: {}", user.getFirstName());
//    }


    private void applicationReadyEvent(Integer str)
    {
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("cmd /c start chrome.exe http://localhost:8082/test?name="+str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
