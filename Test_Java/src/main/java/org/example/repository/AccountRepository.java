package org.example.repository;

import org.example.model.Account;

import java.util.List;

public interface AccountRepository {
    Account createAccountInRepo(Account account);
    Account findAccountByFullname(String fullname);
    Account findAccountByUsername(String username);
    List<Account> getAllAccountInRepo();
    Integer deleteAccountInRepo(String username);
    Account updateAccountInRepo(String needUpdateUsername, Account account);
}
