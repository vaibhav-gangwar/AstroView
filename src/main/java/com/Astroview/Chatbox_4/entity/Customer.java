package com.Astroview.Chatbox_4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "customer")
public class Customer {

        @Id
        private String mobileNo;

        @NotNull
        private String firstName;

        @NotNull
        private String lastName;

        @NotNull
        private LocalDate dateOfBirth;

        @NotNull
        private LocalTime timeOfBirth;

        @NotNull
        private String emailId;

        @NotNull
        private String placeOfBirth;

        @NotNull
        private String gender;

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

    @Override
    public String toString() {
        return "Customer{" +
                "mobileNo='" + mobileNo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", timeOfBirth=" + timeOfBirth +
                ", emailId='" + emailId + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Customer(String mobileNo, String firstName, String lastName, LocalDate dateOfBirth, LocalTime timeOfBirth, String emailId, String placeOfBirth, String gender) {
        this.mobileNo = mobileNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.timeOfBirth = timeOfBirth;
        this.emailId = emailId;
        this.placeOfBirth = placeOfBirth;
        this.gender = gender;
    }

    public Customer() {

    }
}
