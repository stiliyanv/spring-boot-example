package com.stiliyanv.spring_boot_example.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer addNewCustomer(CustomerRequest customerRequest) {
        Customer newCustomer = new Customer();
        newCustomer.setName(customerRequest.name());
        newCustomer.setEmail(customerRequest.email());
        newCustomer.setAge(customerRequest.age());
        return customerRepository.save(newCustomer);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    // What is the best response when customer with such id doesn't exists?
    public void updateCustomer(Integer id, CustomerRequest customerRequest) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            if (customerRequest.name() != null) {
                existingCustomer.setName(customerRequest.name());
            }
            if (customerRequest.email() != null) {
                existingCustomer.setEmail(customerRequest.email());
            }
            if (customerRequest.age() != null) {
                existingCustomer.setAge(customerRequest.age());
            }
            customerRepository.save(existingCustomer);
        }
    }
}
