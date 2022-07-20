package com.praveen.rentcloud.profileservice.repository;

import com.praveen.rentcloud.commons.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}
