package com.Astroview.Chatbox_4.service;

import com.Astroview.Chatbox_4.entity.Customer;
import com.Astroview.Chatbox_4.entity.LoginHistory;
import com.Astroview.Chatbox_4.repository.CustomerRepository;
import com.Astroview.Chatbox_4.repository.LoginHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoginHistoryRepository loginHistoryRepository;

    public Customer handleCustomerLogin(String mobileNo, String otp, String generatedOtp) {
        if (!otp.equals(generatedOtp)) {
            throw new IllegalArgumentException("Invalid OTP");
        }

        Customer customer = customerRepository.findById(mobileNo).orElse(null);

        if (customer == null) {
            // Create a new customer if not exists
            customer = new Customer();
            customer.setMobileNo(mobileNo);
            // Set other fields here (to be retrieved from the frontend)
            customerRepository.save(customer);
        }

        // Record login history
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setMobileNo(mobileNo);
        loginHistoryRepository.save(loginHistory);

        return customer;
    }
}

