package com.yogesh.jpa_rest.model;

import com.yogesh.jpa_rest.service.UserService;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Double balance;

    public User(String name, String email, Double balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;
    }
}
