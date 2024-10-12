package com.stiliyanv.spring_boot_example.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController implements CustomerControllerApi {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @Override
    public ResponseEntity<Customer> getCustomer(Integer id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @Override
    public ResponseEntity<Customer> addCustomer(CustomerRequest customerRequest) {
        Customer newCustomer = customerService.addNewCustomer(customerRequest);
        return ResponseEntity.ok(newCustomer);
    }

    @Override
    public ResponseEntity<Void> deleteCustomer(Integer id) {
        if (customerService.existsById(id)) {
            customerService.deleteCustomerById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }

    @Override
    public ResponseEntity<Customer> updateCustomer(Integer id,
                                                   CustomerRequest customerRequest) {
        Customer customer = customerService.updateCustomer(id, customerRequest);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }
}
