package org.example.controller;

import org.example.dto.CreateAccountDTO;
import org.example.dto.UpdateAccountDTO;
import org.example.model.Account;
import org.example.service.AccountService;
import org.example.service.impl.AccountServiceImpl;

import java.util.List;

public class AccountController {
    //Gọi xuống tầng Service
    private AccountService accountService = new AccountServiceImpl();

    //Create Student
    public Account createAccount(CreateAccountDTO createAccountDTO) {
        return accountService.createAccountInSer(createAccountDTO);
    }

    //Get All Account
    public List<Account> getAllAccount (){
        return accountService.getAllAccountInSer();
    }

    //Delete Account
    public void deleteAccount(String username){
        accountService.deleteAccountInSer(username);
    }

    //Check Account
    public void checkAccount(String username){
        accountService.checkAccountInSer(username);
    }

    //Update Account
    public Account updateAccount(String needUpdateUsername, UpdateAccountDTO updateAccountDTO){
        return accountService.updateAccountInSer(needUpdateUsername, updateAccountDTO);
    }
}
