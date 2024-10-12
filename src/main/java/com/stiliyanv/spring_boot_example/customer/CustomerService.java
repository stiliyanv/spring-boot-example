package com.stiliyanv.spring_boot_example.customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(Integer id);

    Customer addNewCustomer(CustomerRequest customerRequest);

    void deleteCustomerById(Integer id);

    boolean existsById(Integer id);

    Customer updateCustomer(Integer id, CustomerRequest customerRequest);
}
