package com.yankov.backend.service;

import com.yankov.backend.model.User;

import java.util.Optional;

public interface UserService {

    User createUser(User user);

    User getUserByEmail(String email);

    User getUserById(Long id);

    boolean existsByEmail(String email);
}
