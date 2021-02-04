package com.kellygemmill.expensetracker.repository;

import com.kellygemmill.expensetracker.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    @Query("Select c FROM Customer c WHERE c.email = ?1")
    Optional<Customer> findCustomerByEmail(String email);

    @Query("Select c FROM Customer c WHERE c.firstName = ?1")
    Optional<Customer> findCustomerByFirstName(String firstName);

    @Transactional
    @Modifying
    @Query("DELETE FROM Customer c WHERE c.id = ?1")
    int deleteCustomerById(UUID ID);

}
