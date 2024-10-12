package com.stiliyanv.spring_boot_example.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("api/v1/customers")
public interface CustomerControllerApi {
    @GetMapping
    ResponseEntity<List<Customer>> getCustomers();

    @GetMapping("{id}")
    ResponseEntity<Customer> getCustomer(@PathVariable Integer id);

    @PostMapping
    ResponseEntity<Customer> addCustomer(@RequestBody CustomerRequest customerRequest);

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteCustomer(@PathVariable Integer id);

    @PutMapping("{id}")
    ResponseEntity<Customer> updateCustomer(@PathVariable Integer id,
                                            @RequestBody CustomerRequest customerRequest);
}
