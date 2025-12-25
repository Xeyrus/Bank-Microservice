package com.bankmicroservice.accounts.repository;

import com.bankmicroservice.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    // Derived Name Method
    Optional<Customer> findByMobileNumber(String mobileNumber);
}
