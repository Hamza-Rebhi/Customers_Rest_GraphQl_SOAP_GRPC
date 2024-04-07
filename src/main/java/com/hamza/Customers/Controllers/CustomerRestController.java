package com.hamza.Customers.Controllers;

import com.hamza.Customers.dto.CustomerDTO;
import com.hamza.Customers.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class CustomerRestController {
    private final CustomerService customerService;
    @GetMapping("/customers")
    public List<CustomerDTO> fetchAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/customers/{id}")
    public CustomerDTO fetchCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }
    @PostMapping("/addcustomer")
    public CustomerDTO addOneCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.createCustomer(customerDTO);
    }
    @DeleteMapping("/del/{id}")
    public void deleteCustomerById(@PathVariable long id){
        customerService.deleteCustomerById(id);
    }
}
