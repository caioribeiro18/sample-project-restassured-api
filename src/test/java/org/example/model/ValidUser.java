package org.example.model;
import lombok.Data;
import lombok.AllArgsConstructor;
@Data
public class ValidUser {
    private String name;
    private String job;

    public ValidUser(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
