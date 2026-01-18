package com.yankov.backend.service;

import com.yankov.backend.enums.Currency;
import com.yankov.backend.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    Account createAccount(Long userId, Currency currency);

    Account getAccountByAccountNumber(String number);

    List<Account> getAccountsByUserId(Long userId);

    void deposit(Account account, BigDecimal amount);

    void withdraw(Account account, BigDecimal amount);
}
