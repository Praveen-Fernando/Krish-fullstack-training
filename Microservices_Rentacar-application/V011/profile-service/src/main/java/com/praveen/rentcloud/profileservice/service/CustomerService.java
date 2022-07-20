package com.praveen.rentcloud.profileservice.service;

import com.praveen.rentcloud.commons.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);
    Customer fetchById(int profileId);
    List<Customer> fetchAllProfiles();
}
