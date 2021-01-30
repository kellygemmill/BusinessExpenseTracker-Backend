package com.kellygemmill.expensetracker.api;

import com.kellygemmill.expensetracker.model.Customer;
import com.kellygemmill.expensetracker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void insertCustomer(@RequestBody Customer customer) {
        customerService.insertCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "{id}")
    public Customer getCustomerById(@PathVariable("id") UUID id) {
        return customerService.getCustomerById(id) // getCustomerById returns an Optional<Customer>
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCustomerById(@PathVariable("id") UUID id) {
        customerService.deleteCustomerById(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id, @RequestBody Customer customerToUpdate) {
        customerService.updateCustomerById(id, customerToUpdate);
    }
}
