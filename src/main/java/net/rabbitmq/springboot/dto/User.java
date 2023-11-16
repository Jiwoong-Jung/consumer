package net.rabbitmq.springboot.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;

    public User() {}
}
