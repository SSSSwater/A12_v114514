package com.example.basicLayout;

import lombok.Data;

@Data
public class User {
    private String account;
    private String password;
    private int role=0;

    public User() {
    }

    public User(int role) {
        this.role = role;
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
