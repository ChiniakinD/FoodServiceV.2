package ru.liga.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Order {
    private Long id;
    private String timestamp;
    private String status;
    private String name;
    private String user;
    private String password;
    public Order() {
        id = 1L;
        timestamp = "now";
        status = "active";
        name = "pizza";
        user = "Penelopa";
        password = "Intellij Idea";
    }
}
