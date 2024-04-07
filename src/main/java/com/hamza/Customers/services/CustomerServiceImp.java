package com.hamza.Customers.services;

import com.hamza.Customers.Mappers.CustomerMapper;
import com.hamza.Customers.Repositories.CustomerRepository;
import com.hamza.Customers.dto.CustomerDTO;
import com.hamza.Customers.exceptions.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService{
    private final CustomerRepository customerRepository;
    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper.INSTANCE::mapCustomerToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return CustomerMapper
                .INSTANCE
                .mapCustomerToCustomerDto(customerRepository.findById(id).get());
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return CustomerMapper.INSTANCE
                .mapCustomerToCustomerDto
                        (customerRepository
                                .save(CustomerMapper.INSTANCE.mapCustomerDtoToCustomer(customerDTO)));
    }

    @Override
    public void deleteCustomerById(Long id) {
           customerRepository.deleteById(id);
    }
}
