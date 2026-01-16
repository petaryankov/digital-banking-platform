package com.yankov.backend.exception;

import com.yankov.backend.constants.ExceptionMessages;

public class InvalidTransactionException extends RuntimeException{

    public InvalidTransactionException() {
        super(String.format(ExceptionMessages.INVALID_TRANSACTION_AMOUNT));
    }
}
