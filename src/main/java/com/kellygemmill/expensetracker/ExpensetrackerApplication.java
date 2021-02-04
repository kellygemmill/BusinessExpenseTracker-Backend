package com.kellygemmill.expensetracker;

import com.kellygemmill.expensetracker.repository.CustomerRepository;
import com.kellygemmill.expensetracker.model.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpensetrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensetrackerApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
//		return args -> {
//			Customer kelly = new Customer(
//					"Bob",
//					"Smith",
//					"bob.smith@gmail.com",
//					"123-456-7890");
//			customerRepository.save(kelly);
//			System.out.println(customerRepository.findCustomerByFirstName("Kelly"));
//		};
//	}
}
