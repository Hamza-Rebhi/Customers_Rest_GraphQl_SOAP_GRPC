package com.hamza.Customers.Mappers;

import com.hamza.Customers.dto.CustomerDTO;
import com.hamza.Customers.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
    Customer mapCustomerDtoToCustomer(CustomerDTO customerDTO);
    CustomerDTO mapCustomerToCustomerDto(Customer customer);
}
