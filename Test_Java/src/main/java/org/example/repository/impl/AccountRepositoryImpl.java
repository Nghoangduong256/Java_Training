package org.example.repository.impl;

import org.example.connection.ConnectionConfig;
import org.example.model.Account;
import org.example.repository.AccountRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    @Override
    public Account createAccountInRepo(Account account) {
        try {
            Connection myConnection = ConnectionConfig.getConnection();
            Statement myStatement = myConnection.createStatement();
            int effectiveRecordNumber = myStatement.executeUpdate("insert into Account(username, fullname, department, position, createdDate) values ('"
                    + account.getUsername() + "','" + account.getFullname() + "','" + account.getDepartment() + "','" + account.getPosition() +
                    "','" + account.getCreatedDate() + "')");

            myConnection.close();
        } catch (Exception exception) {
            System.out.println("Lỗi khi xử lý connection" + exception.getMessage());
        }

        return findAccount(account.getFullname());
    }

    @Override
    public Account findAccount(String fullname) {
        Account createdAccount = null;
        try {
            Connection myConnection = ConnectionConfig.getConnection();
            Statement myStatement = myConnection.createStatement();
            ResultSet myResultSet = myStatement.executeQuery(
                    "select * from Account where fullname = '" + fullname + "'");

            while (myResultSet.next()) {
                createdAccount = new Account();
                createdAccount.setId(myResultSet.getInt("id"));
                createdAccount.setUsername(myResultSet.getString("username"));
                createdAccount.setFullname(myResultSet.getString("fullname"));
                createdAccount.setDepartment(myResultSet.getString("department"));
                createdAccount.setPosition(myResultSet.getString("position"));
                createdAccount.setCreatedDate(myResultSet.getDate("createdDate").toLocalDate());
            }

            myConnection.close();
        } catch (Exception exception) {
            System.out.println("Lỗi khi xử lý connection" + exception.getMessage());
        }

        return createdAccount;
    }

    @Override
    public List<Account> getAllAccountInRepo() {
        List<Account> accounts = new ArrayList<>();
        try {
            Connection myConnection = ConnectionConfig.getConnection();
            Statement myStatement = myConnection.createStatement();
            ResultSet myResultSet = myStatement.executeQuery(
                    "select * from Account ");

            while (myResultSet.next()) {
                Account account = new Account();
                account.setId(myResultSet.getInt("id"));
                account.setUsername(myResultSet.getString("username"));
                account.setFullname(myResultSet.getString("fullname"));
                account.setDepartment(myResultSet.getString("department"));
                account.setPosition(myResultSet.getString("position"));
                account.setCreatedDate(myResultSet.getDate("createdDate").toLocalDate());
                accounts.add(account);
            }

            myConnection.close();
        } catch (Exception exception) {
            System.out.println("Lỗi khi xử lý connection" + exception.getMessage());
        }

        return accounts;

    }

    @Override
    public Integer deleteAccountInRepo(String username) {
        int effectiveRecordNumber = 0;

        try {
            Connection myConnection = ConnectionConfig.getConnection();
            Statement myStatement = myConnection.createStatement();
            effectiveRecordNumber = myStatement.executeUpdate(
                    "delete from Account where username = '" + username + "'"
            );

            myConnection.close();
        } catch (Exception exception) {
            System.out.println("Lỗi khi xử lý connection" + exception.getMessage());
        }

        return effectiveRecordNumber;
    }

    @Override
    public Account updateAccountInRepo(Account account) {
        try {
            Connection myConnection = ConnectionConfig.getConnection();
            Statement myStatement = myConnection.createStatement();
            int effectiveRecordNumber = myStatement.executeUpdate("update Account set username = '" + account.getUsername() + "', fullname ='" +account.getFullname()+"', department='" + account.getDepartment()+"',position='" + account.getPosition() + "',createdDate='" + account.getCreatedDate() +"'");

            myConnection.close();
        } catch (Exception exception) {
            System.out.println("Lỗi khi xử lý connection" + exception.getMessage());
        }

        return findAccount(account.getFullname());
    }
}
