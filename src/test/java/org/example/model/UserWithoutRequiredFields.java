package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserWithoutRequiredFields {
    private String bodyEmpty;

    public UserWithoutRequiredFields(String bodyEmpty) {
        this.bodyEmpty = bodyEmpty;
    }
}
