package com.kellygemmill.expensetracker.service;

import com.kellygemmill.expensetracker.dao.CustomerDao;
import com.kellygemmill.expensetracker.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("fake") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public int insertCustomer(Customer customer) {
        return customerDao.insertCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomers();
    }

    public Optional<Customer> getCustomerById(UUID id) {
        return customerDao.selectCustomerById(id);
    }

    public int deleteCustomerById(UUID id) {
        return customerDao.deleteCustomerById(id);
    }

    public int updateCustomerById(UUID id, Customer newCustomer) {
        return customerDao.updateCustomerById(id, newCustomer);
    }
}
