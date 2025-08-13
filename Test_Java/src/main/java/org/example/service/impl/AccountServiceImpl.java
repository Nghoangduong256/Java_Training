package org.example.service.impl;

import org.example.dto.CreateAccountDTO;
import org.example.dto.UpdateAccountDTO;
import org.example.model.Account;
import org.example.repository.AccountRepository;
import org.example.repository.impl.AccountRepositoryImpl;
import org.example.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository = new AccountRepositoryImpl();

    @Override
    public Account createAccountInSer(CreateAccountDTO createAccountDTO) {
        //Validate
        //Kiểm tra username
        if (createAccountDTO.getUsername() == null || createAccountDTO.getUsername().isEmpty() || createAccountDTO.getUsername().matches("\\d+")) {
            throw new IllegalArgumentException("Username không hợp lệ! Vui lòng nhập lại username");
        }

        //Kiểm tra fullname
        if (createAccountDTO.getFullname() == null || createAccountDTO.getFullname().isEmpty() || createAccountDTO.getFullname().matches(".*\\d.*")) {
            throw new IllegalArgumentException("Họ tên không hợp lệ! Vui lòng nhập lại họ tên");
        }

        //Kiểm tra department
        if (createAccountDTO.getDepartment() == null || createAccountDTO.getDepartment().isEmpty() || createAccountDTO.getDepartment().matches("\\d+")) {
            throw new IllegalArgumentException("Department không hợp lệ! Vui lòng nhập lại department");
        }

        //Kiểm tra position
        if (createAccountDTO.getPosition() == null || createAccountDTO.getPosition().isEmpty() || createAccountDTO.getPosition().matches("\\d+")) {
            throw new IllegalArgumentException("Position không hợp lệ! Vui lòng nhập lại position");
        }

        Account newAccount = new Account();
        newAccount.setUsername(createAccountDTO.getUsername());
        newAccount.setFullname(createAccountDTO.getFullname());
        newAccount.setDepartment(createAccountDTO.getDepartment());
        newAccount.setPosition(createAccountDTO.getPosition());
        newAccount.setCreatedDate(createAccountDTO.getCreatedDate());

        return accountRepository.createAccountInRepo(newAccount);
    }

    @Override
    public List<Account> getAllAccountInSer() {
        return accountRepository.getAllAccountInRepo();
    }

    @Override
    public void deleteAccountInSer(String username) {
        //Validate
        //Kiểm tra username
        if (username == null) {
            throw new IllegalArgumentException("Vui lòng nhập username!");
        }

        if (accountRepository.deleteAccountInRepo(username) == 0) {
            throw new IllegalArgumentException("Không tìm thấy Account. Vui lòng nhập lại username");
        }
    }

    @Override
    public void checkAccountInSer(String username) {
        //Validate
        //Kiểm tra username
        if (username == null) {
            throw new IllegalArgumentException("Vui lòng nhập username!");
        }

        if (accountRepository.findAccountByUsername(username) == null) {
            throw new IllegalArgumentException("Không tìm thấy Account. Vui lòng nhập lại username");
        }
    }

    @Override
    public Account updateAccountInSer(String needUpdateUsername, UpdateAccountDTO updateAccountDTO) {
        //Validate
        //Kiểm tra username
        if (updateAccountDTO.getUsername() == null || updateAccountDTO.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Vui lòng nhập username!");
        }

        //Kiểm tra fullname
        if (updateAccountDTO.getFullname() == null || updateAccountDTO.getFullname().isEmpty()) {
            throw new IllegalArgumentException("Vui lòng nhập họ tên!");
        }

        //Kiểm tra department
        if (updateAccountDTO.getDepartment() == null || updateAccountDTO.getDepartment().isEmpty()) {
            throw new IllegalArgumentException("Vui lòng nhập phòng ban!");
        }

        //Kiểm tra position
        if (updateAccountDTO.getPosition() == null || updateAccountDTO.getPosition().isEmpty()) {
            throw new IllegalArgumentException("Vui lòng nhập chức vụ!");
        }

        Account updatedAccount = new Account();
        updatedAccount.setUsername(updateAccountDTO.getUsername());
        updatedAccount.setFullname(updateAccountDTO.getFullname());
        updatedAccount.setDepartment(updateAccountDTO.getDepartment());
        updatedAccount.setPosition(updateAccountDTO.getPosition());
        updatedAccount.setCreatedDate(updateAccountDTO.getCreatedDate());

        return accountRepository.updateAccountInRepo(needUpdateUsername, updatedAccount);
    }
}
