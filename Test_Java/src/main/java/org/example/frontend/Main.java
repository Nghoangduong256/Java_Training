package org.example.frontend;

import org.example.controller.AccountController;
import org.example.dto.CreateAccountDTO;
import org.example.dto.UpdateAccountDTO;
import org.example.model.Account;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Gọi xuống Controller
        AccountController accountController = new AccountController();

//        //Tạo mới Account
//        CreateAccountDTO accountDTO = new CreateAccountDTO();
//
//        System.out.println("================");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Thêm Account mới:");
//        System.out.println("Nhập username: ");
//            String username = scanner.nextLine();
//            accountDTO.setUsername(username);
//        System.out.println("Nhập Fullname: ");
//            String fullname = scanner.nextLine();
//            accountDTO.setFullname(fullname);
//        System.out.println("Nhập Department:");
//            String department = scanner.nextLine();
//            accountDTO.setDepartment(department);
//        System.out.println("Nhập Position: ");
//            String position = scanner.nextLine();
//            accountDTO.setPosition(position);
//            scanner.close();
//        accountDTO.setCreatedDate(LocalDate.now());
//        Account newAccount = accountController.createAccount(accountDTO);
//
//        System.out.println("Tạo Account thành công! Thông tin Account vừa tạo:");
//        System.out.println(newAccount);

        //In ra danh sách Account
        List<Account> accounts = accountController.getAllAccount();
        System.out.println("================");
        System.out.println("Danh sách Account:");
        for (Account account : accounts){
            System.out.println(account);
        }

        //Xóa Account
        Scanner scanner2 = new Scanner(System.in);

        System.out.println("================");
        System.out.println("Nhập username cần xóa:");
        String deleteUsername = scanner2.nextLine();
        accountController.deleteAccount(deleteUsername);
        System.out.println("Đã xóa Account: " + deleteUsername);
        scanner2.close();

        //Sửa Account
        Scanner scanner3 = new Scanner(System.in);

        System.out.println("================");
        System.out.println("Nhập username cần sửa:");
        String needUpdateUsername = scanner3.nextLine();
        accountController.checkAccount(needUpdateUsername);

        UpdateAccountDTO updateAccountDTO = new UpdateAccountDTO();
        System.out.println("Bắt đầu chỉnh sửa Username:");
        System.out.println("Nhập username mới: ");
            String username = scanner3.nextLine();
            updateAccountDTO.setUsername(username);
        System.out.println("Nhập Fullname mới: ");
            String fullname = scanner3.nextLine();
            updateAccountDTO.setFullname(fullname);
        System.out.println("Nhập Department mới:");
            String department = scanner3.nextLine();
            updateAccountDTO.setDepartment(department);
        System.out.println("Nhập Position mới: ");
            String position = scanner3.nextLine();
            updateAccountDTO.setPosition(position);
            updateAccountDTO.setCreatedDate(LocalDate.now());
        scanner3.close();

        Account updatedAccount = accountController.updateAccount(needUpdateUsername, updateAccountDTO);
        System.out.println("Cập nhật Account thành công!");
        System.out.println(updatedAccount);
    }
}
