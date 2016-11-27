package com.example.asiantech.scanqrcode.model;

import java.io.Serializable;

/**
 * Created by asiantech on 22/11/2016.
 */

public class Account implements Serializable {
    private int id;
    private int passwordHash;
    private String username;
    private String password;
    private String authToken;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;
    private String role;
    private long deleteAt;

    public Account(int id, int passwordHash, String username, String password, String authToken, String fullName, String phoneNumber, String email, String address, String role, int deleteAt) {
        this.id = id;
        this.passwordHash = passwordHash;
        this.username = username;
        this.password = password;
        this.authToken = authToken;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.role = role;
        this.deleteAt = deleteAt;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(int passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(long deleteAt) {
        this.deleteAt = deleteAt;
    }
}
