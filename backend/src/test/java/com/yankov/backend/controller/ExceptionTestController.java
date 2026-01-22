package com.yankov.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller used only to trigger exceptions for testing the GlobalExceptionHandler
@RestController
@RequestMapping("/test/exceptions")
public class ExceptionTestController {

    @GetMapping("/user-not-found")
    public void userNotFound() {}

    @GetMapping("/user-already-exists")
    public void userAlreadyExists() {}

    @GetMapping("/account-not-found")
    public void accountNotFound() {}

    @GetMapping("/insufficient-balance")
    public void insufficientBalance() {}

    @GetMapping("/invalid-transaction")
    public void invalidTransaction() {}

    @GetMapping("/currency-mismatch")
    public void currencyMismatch() {}
}
