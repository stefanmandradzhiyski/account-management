package com.snmi.component;

import com.snmi.exception.NotFoundException;
import com.snmi.domain.Account;
import com.snmi.repository.AccountRepository;
import org.springframework.stereotype.Component;

@Component
public class AccountComponent {

    private final AccountRepository accountRepository;

    public AccountComponent(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findByIdOrThrowNotFoundException(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(() -> new NotFoundException(accountId));
    }

}
