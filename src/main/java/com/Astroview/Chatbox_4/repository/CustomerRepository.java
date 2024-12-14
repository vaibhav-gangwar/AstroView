package com.Astroview.Chatbox_4.repository;

import com.Astroview.Chatbox_4.entity.Customer;
import com.Astroview.Chatbox_4.entity.RestResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}



