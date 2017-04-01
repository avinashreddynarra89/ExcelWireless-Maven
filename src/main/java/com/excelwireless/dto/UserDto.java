package com.excelwireless.dto;

/**
 * Created by asp5045 on 5/25/16.
 */
public class UserDto {

    private int userId;
    private String username;
    private String password;
    private String userRole;
    private String createdDate;
    private double horlyRate;
    private double userCommissionPercentage;


    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getUserRole() {
        return userRole;
    }

    public double getHorlyRate() {
        return horlyRate;
    }

    public void setHorlyRate(double horlyRate) {
        this.horlyRate = horlyRate;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public double getUserCommissionPercentage() {
        return userCommissionPercentage;
    }

    public void setUserCommissionPercentage(double userCommissionPercentage) {
        this.userCommissionPercentage = userCommissionPercentage;
    }
}
