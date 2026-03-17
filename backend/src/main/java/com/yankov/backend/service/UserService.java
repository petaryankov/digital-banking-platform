package com.yankov.backend.service;

import com.yankov.backend.model.User;

public interface UserService {

    User createUser(User user);

    User getUserByEmail(String email);

    User getUserById(Long id);

    boolean existsByEmail(String email);

    void deactivateUser(String email);
}
