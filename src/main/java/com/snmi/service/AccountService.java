package com.snmi.service;

import com.snmi.component.AccountComponent;
import com.snmi.dto.AccountDTO;
import com.snmi.dto.WholeAccountDTO;
import com.snmi.mapper.AccountMapper;
import com.snmi.domain.Account;
import com.snmi.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final AccountComponent accountComponent;

    public AccountService(
            AccountRepository accountRepository,
            AccountMapper accountMapper,
            AccountComponent accountComponent
    ) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.accountComponent = accountComponent;
    }

    public WholeAccountDTO createAccount(AccountDTO accountDTO) {
        Account newAccount = accountRepository.save(accountMapper.toAccount(accountDTO));
        LOGGER.info(String.format("The new account with id=%s has been created successfully", newAccount.getId()));

        return accountMapper.toWholeAccountDTO(newAccount);
    }

    public WholeAccountDTO getAccount(Long accountId) {
        Account existingAccount = accountComponent.findByIdOrThrowNotFoundException(accountId);
        LOGGER.info(String.format("Account with id=%s has been retrieved successfully", accountId));

        return accountMapper.toWholeAccountDTO(existingAccount);
    }

    public List<WholeAccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        LOGGER.info("All accounts have been retrieved successfully");

        return accounts.stream()
                .map(accountMapper::toWholeAccountDTO)
                .collect(Collectors.toList());
    }

    public WholeAccountDTO updateAccount(Long accountId, AccountDTO accountDTO) {
        LOGGER.info(String.format("Updating an account with id=%s", accountId));
        Account existingAccount = accountComponent.findByIdOrThrowNotFoundException(accountId);
        existingAccount.updateAccount(accountDTO.getFirstName(), accountDTO.getLastName(), accountDTO.getEmail(),
                accountDTO.getDateOfBirth());
        LOGGER.info("Account properties have been updated successfully");

        return accountMapper.toWholeAccountDTO(accountRepository.save(existingAccount));
    }

    public void deleteAccount(Long accountId) {
        accountRepository.delete(accountComponent.findByIdOrThrowNotFoundException(accountId));
        LOGGER.info(String.format("Account with id=%s has been deleted successfully", accountId));
    }
}
