package net.rabbitmq.springboot.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class User implements Serializable {
    private int id;
    private String firstName;
    private String lastName;

    public User() {

    }
}
