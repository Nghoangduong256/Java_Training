package org.example.service;

import org.example.dto.CreateAccountDTO;
import org.example.dto.UpdateAccountDTO;
import org.example.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccountInSer(CreateAccountDTO createAccountDTO);
    List<Account> getAllAccountInSer();
    void deleteAccountInSer(String username);
    void checkAccountInSer(String username);
    Account updateAccountInSer(String username, UpdateAccountDTO updateAccountDTO);
}
