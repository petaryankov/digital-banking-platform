package com.yankov.backend.service;

import com.yankov.backend.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserByEmail(String email);

    User getUserById(Long id);

    boolean existsByEmail(String email);

    void activateUser(Long id);

    void deactivateUser(String email);

    List<User> getAllUsers();
}
