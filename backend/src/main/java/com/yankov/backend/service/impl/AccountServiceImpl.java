package com.yankov.backend.service.impl;

import com.yankov.backend.exception.InsufficientBalanceException;
import com.yankov.backend.exception.InvalidTransactionException;
import com.yankov.backend.model.Account;
import com.yankov.backend.model.User;
import com.yankov.backend.repository.AccountRepository;
import com.yankov.backend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    // Create account
    @Transactional
    @Override
    public Account createAccount(Account account) {

        return accountRepository.save(account);
    }

    // Get account by the account number
    @Transactional(readOnly = true)
    @Override
    public Optional<Account> getAccountByNumber(String number) {
        return accountRepository.findByAccountNumber(number);
    }

    // Get account by the user
    @Transactional(readOnly = true)
    @Override
    public List<Account> getAccountByUser(User user) {

        return accountRepository.findByUser(user);
    }

    @Transactional
    @Override
    public Account deposit(Account account, BigDecimal amount) {

        // Prevent invalid deposit amount 0 or negative
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidTransactionException();
        }
        account.setBalance(account.getBalance().add(amount));

        return accountRepository.save(account);
    }

    @Transactional
    @Override
    public Account withdraw(Account account, BigDecimal amount) {

        // Prevent invalid withdrawal amounts 0 or negative
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidTransactionException();
        }

        // Prevent withdrawing more money than the account holds
        if (account.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException(
                    account.getId(), amount
            );
        }

        account.setBalance(account.getBalance().subtract(amount));

        return accountRepository.save(account);
    }
}
