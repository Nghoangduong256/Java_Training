package org.example.dto;

import java.time.LocalDate;
import java.util.Date;

public class CreateAccountDTO {
    private String username;
    private String fullname;
    private String department;
    private String position;
    private LocalDate createdDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "CreateAccountDTO{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
