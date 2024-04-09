package com.hamza.Customers.Controllers;

import com.hamza.Customers.dto.CustomerDTO;
import com.hamza.Customers.services.CustomerService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Component
@WebService(serviceName = "CustomerWS")
@RequiredArgsConstructor
public class CustomerSoapController {
    private final CustomerService customerService;
    @WebMethod
    public ResponseEntity<List<CustomerDTO>> fetchAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @WebMethod
    public  ResponseEntity<CustomerDTO>fetchCustomerById(@WebParam Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    @WebMethod
    public ResponseEntity<CustomerDTO>addOneCustomer(@WebParam CustomerDTO customerDTO){
        return new ResponseEntity<>(customerService.createCustomer(customerDTO), HttpStatus.CREATED);
    }
    @WebMethod
    public void deleteCustomerById(@WebParam Long id){
        customerService.deleteCustomerById(id);
    }
}
