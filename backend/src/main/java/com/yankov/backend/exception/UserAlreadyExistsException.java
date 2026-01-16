package com.yankov.backend.exception;

import static com.yankov.backend.constants.ExceptionMessages.USER_ALREADY_EXISTS;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String email) {
        super(String.format(USER_ALREADY_EXISTS, email));
    }
}
