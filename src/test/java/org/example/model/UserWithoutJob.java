package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserWithoutJob {
    private String name;

    public UserWithoutJob(String name) {
        this.name = name;
    }
}
