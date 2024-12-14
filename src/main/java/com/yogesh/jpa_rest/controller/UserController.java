package com.yogesh.jpa_rest.controller;

import com.yogesh.jpa_rest.model.User;
import com.yogesh.jpa_rest.model.UserDTO;
import com.yogesh.jpa_rest.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/transfer")
    public String transferFunds(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam Double amount) {
        boolean result = userService.transferFunds(senderId, receiverId, amount);
        return result ? "Transfer Successful" : "Transfer Failed";
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody UserDTO inUser) {
        System.out.println("Create User Request Received: " + inUser.toString());
        return userService.createUser(new User(inUser.getName(), inUser.getEmail(), inUser.getBalance()));
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
