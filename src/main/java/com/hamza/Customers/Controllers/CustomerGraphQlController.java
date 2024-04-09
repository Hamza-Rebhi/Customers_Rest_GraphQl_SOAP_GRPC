package com.hamza.Customers.Controllers;

import com.hamza.Customers.dto.CustomerDTO;
import com.hamza.Customers.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerGraphQlController {
    private final CustomerService customerService;
    @QueryMapping
    public ResponseEntity<List<CustomerDTO>> allCustomers(){
        return ResponseEntity.ok( customerService.getAllCustomers());
    }
    @QueryMapping
    public ResponseEntity<CustomerDTO> customerById(@Argument Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    @MutationMapping
    public ResponseEntity<CustomerDTO> addOneCustomer(@Argument CustomerDTO customerDTO){
        return new ResponseEntity<>(customerService.createCustomer(customerDTO), HttpStatus.CREATED);
    }
    @MutationMapping
    public void deleteCustomerById(@Argument Long id){
        customerService.deleteCustomerById(id);
    }

}
