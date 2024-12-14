package com.yogesh.jpa_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("balance")
    private double balance;

}
