package com.hamza.Customers.services;

import com.hamza.Customers.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO>getAllCustomers();
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    void deleteCustomerById(Long id);

}
