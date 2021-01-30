package com.kellygemmill.expensetracker.dao;

import com.kellygemmill.expensetracker.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fake")
public class FakeCustomerDao implements CustomerDao{

    private static List<Customer> DB = new ArrayList<>();

    @Override
    public int insertCustomer(UUID id, Customer customer) {
        DB.add(new Customer(id, customer));
        return 1;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return DB;
    }

    @Override
    public Optional<Customer> selectCustomerById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteCustomerById(UUID id) {
        Optional<Customer> customer = selectCustomerById(id);
        if (customer.isEmpty()) {
            return 0;
        }
        DB.remove(customer.get());
        return 1;
    }

    @Override
    public int updateCustomerById(UUID id, Customer updatedCustomer) {
        return selectCustomerById(id)
                .map(customer -> {
                    int indexOfCustomerToUpdate = DB.indexOf(customer);
                    if (indexOfCustomerToUpdate >= 0) {
                        DB.set(indexOfCustomerToUpdate, new Customer(id, updatedCustomer));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);

    }

}
