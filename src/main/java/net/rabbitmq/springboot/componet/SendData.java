package net.rabbitmq.springboot.componet;

import net.rabbitmq.springboot.dto.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SendData {
    private static RestTemplate restTemplate;

    public static ResponseEntity<User> sendEngine() {

        User requestDto = User.builder()
                .id(11)
                .lastName("김")
                .firstName("가나")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<User> entity = new HttpEntity<>(requestDto, headers);

        String url = "http://localhost:8081/";

        return restTemplate.exchange(url, HttpMethod.GET, entity, User.class);
    }
}
