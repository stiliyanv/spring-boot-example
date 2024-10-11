package com.stiliyanv.spring_boot_example.customer;

public record CustomerRequest(
        String name,
        String email,
        Integer age
){}
