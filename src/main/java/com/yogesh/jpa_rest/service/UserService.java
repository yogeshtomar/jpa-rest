package com.yogesh.jpa_rest.service;

import com.yogesh.jpa_rest.model.User;
import com.yogesh.jpa_rest.model.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    protected UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public boolean transferFunds(Long senderId, Long receiverId, Double amount) {
        // Fetch sender details
        User sender = userRepository.findById(senderId).orElseThrow(() -> new IllegalArgumentException("Sender not found"));

        User receiver = userRepository.findById(receiverId).orElseThrow(() -> new IllegalArgumentException("Receiver not found"));

        if (sender.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient Balance.");
        }

        sender.setBalance(sender.getBalance() - amount);
        userRepository.save(sender);
        receiver.setBalance(receiver.getBalance() + amount);
        userRepository.save(receiver);
//         if (true) throw new RuntimeException("Simulated exception to trigger rollback");

        return true;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User with id" + id + " not found."));
    }
}
