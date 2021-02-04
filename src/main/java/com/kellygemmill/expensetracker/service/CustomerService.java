package com.kellygemmill.expensetracker.service;

import com.kellygemmill.expensetracker.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

//    public int insertCustomer(Customer customer) {
//        return dataAccessObject.insertNew(customer);
//    }
//
//    public List<Customer> getAllCustomers() {
//        return dataAccessObject.selectAllCustomers();
//    }
//
//    public Optional<Customer> getCustomerById(UUID id) {
//        return dataAccessObject.selectCustomerById(id);
//    }
//
//    public int deleteCustomerById(UUID id) {
//        return dataAccessObject.deleteCustomerById(id);
//    }
//
//    public int updateCustomerById(UUID id, Customer newCustomer) {
//        return dataAccessObject.updateCustomerById(id, newCustomer);
//    }
}
