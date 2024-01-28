package org.example.model;

import lombok.Data;

@Data
public class UserWithoutName {
    private String job;

    public UserWithoutName(String job) {
        this.job = job;
    }
}
