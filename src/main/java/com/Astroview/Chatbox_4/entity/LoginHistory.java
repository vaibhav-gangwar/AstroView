package com.Astroview.Chatbox_4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "login_history")
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String mobileNo;

    @NotNull
    private LocalDateTime loginTime = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "LoginHistory{" +
                "id=" + id +
                ", mobileNo='" + mobileNo + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }

    public LoginHistory(Long id, String mobileNo, LocalDateTime loginTime) {
        this.id = id;
        this.mobileNo = mobileNo;
        this.loginTime = loginTime;
    }

    public LoginHistory() {

    }

}

