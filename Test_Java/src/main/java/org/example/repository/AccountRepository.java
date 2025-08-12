package org.example.repository;

import org.example.model.Account;

import java.util.List;

public interface AccountRepository {
    Account createAccountInRepo(Account account);
    Account findAccount(String fullname);
    List<Account> getAllAccountInRepo();
    Integer deleteAccountInRepo(String username);
    Account updateAccountInRepo(Account account);
}
