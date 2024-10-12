package com.stiliyanv.spring_boot_example.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    @Override
    public Customer addNewCustomer(CustomerRequest customerRequest) {
        Customer newCustomer = new Customer();
        newCustomer.setName(customerRequest.name());
        newCustomer.setEmail(customerRequest.email());
        newCustomer.setAge(customerRequest.age());
        return customerRepository.save(newCustomer);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return customerRepository.existsById(id);
    }

    @Override
    public Customer updateCustomer(Integer id, CustomerRequest customerRequest) {
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
            return existingCustomer;
        } else {
            return null;
        }
    }
}
