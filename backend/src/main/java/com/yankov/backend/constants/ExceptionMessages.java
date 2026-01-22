package com.yankov.backend.constants;

public class ExceptionMessages {


    // prevent instantiation
    private ExceptionMessages() {}

    // ===== USER =====

    // Not found by ID
    public static final String USER_NOT_FOUND_BY_ID = "User not found with id %d";

    // Not found by email
    public static final String USER_NOT_FOUND_BY_EMAIL = "User with email %s not found";

    // Already exists with this email
    public static final String USER_ALREADY_EXISTS = "User already exists with email %s";

    // ===== ACCOUNT =====

    public static final String ACCOUNT_NOT_FOUND_BY_ID =
            "Account not found with id %d";

    public static final String ACCOUNT_NOT_FOUND_BY_ACCOUNT_NUMBER =
            "Account with account number %s not found";

    public static final String INSUFFICIENT_BALANCE =
            "Account %d has insufficient balance for amount %s";

    // ===== TRANSACTION =====
    public static final String INVALID_TRANSACTION_AMOUNT =
            "Transaction amount @d must be greater than zero";

    public static final String CURRENCY_MISMATCH = "Currency mismatch: source=%s, target=%s";

}
