package com.yogesh.jpa_rest.service;

import com.yogesh.jpa_rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
