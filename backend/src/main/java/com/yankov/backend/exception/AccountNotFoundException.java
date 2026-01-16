package com.yankov.backend.exception;

import com.yankov.backend.constants.ExceptionMessages;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(Long id) {
        super(String.format(
                ExceptionMessages.ACCOUNT_NOT_FOUND_BY_ID, id
        ));
    }
}
